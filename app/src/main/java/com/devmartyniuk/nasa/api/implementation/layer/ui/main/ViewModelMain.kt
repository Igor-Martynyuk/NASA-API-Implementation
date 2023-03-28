package com.devmartyniuk.nasa.api.implementation.layer.ui.main

import androidx.lifecycle.*
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.RetrofitGatewayNeoWS
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.CaseGetNearEarthObjectList
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ViewModelMain : ViewModel() {
    private val _errorData = LiveEvent<Throwable?>()
    val errorData = _errorData as LiveData<Throwable?>

    private val _isInProgressData = MutableLiveData(false)
    val isInProgressData get() = _isInProgressData as LiveData<Boolean>

    private val _nearEarthObjectsData = MutableLiveData(listOf<NearEarthObject>())
    val nearEarthObjectsData get() = _nearEarthObjectsData as LiveData<List<NearEarthObject>>

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .addInterceptor {
            it.proceed(
                it.request()
                    .newBuilder()
                    .addHeader("ContentScope-Type", "application/json")
                    .build()
            )
        }
        .addInterceptor {
            val original = it.request()
            it.proceed(
                original.newBuilder()
                    .url(
                        original
                            .url
                            .newBuilder()
                            .addQueryParameter(
                                "api_key",
                                "b5E4vg5K4TTksRxgaZzjSldHlnKhM1TfbsW7Cg9K"
                            )
                            .build(),
                    )
                    .build()
            )
        }
        .build()

    private val gateway: RetrofitGatewayNeoWS = RetrofitGatewayNeoWS(
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    )

    fun onViewReady() = viewModelScope.launch {
        _nearEarthObjectsData.value = CaseGetNearEarthObjectList(gateway)
            .prepare(Unit)
            .flowOn(Dispatchers.IO)
            .onStart { _isInProgressData.value = true }
            .onCompletion { _isInProgressData.value = false }
            .catch { _errorData.value = it }
            .toList()
    }
}