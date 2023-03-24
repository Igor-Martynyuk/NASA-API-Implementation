package com.devmartyniuk.nasa.api.implementation.layer.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.devmartyniuk.nasa.api.implementation.R
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.RetrofitGatewayNeoWS
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.CaseGetNearEarthObjectList
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }

    override fun onResume() {
        super.onResume()

        val output = findViewById<TextView>(R.id.output)
        var received = 0

        CaseGetNearEarthObjectList(gateway)
            .prepare(Unit)
            .flowOn(Dispatchers.IO)
            .onStart { output.text = "loading" }
            .onEach { received++ }
            .onCompletion { output.text = "Success! Received objects count: $received" }
            .catch { output.text = "Error! ${it::class.simpleName}" }
            .launchIn(lifecycleScope)
    }
}