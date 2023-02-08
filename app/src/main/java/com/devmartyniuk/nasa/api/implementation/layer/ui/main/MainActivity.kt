package com.devmartyniuk.nasa.api.implementation.layer.ui.main

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.devmartyniuk.nasa.api.implementation.R
import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.RetrofitGatewayNeoWS
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
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

        lifecycleScope.launch(
            CoroutineExceptionHandler { _, e ->
                lifecycleScope.launch {
                    e.printStackTrace()
                    Toast.makeText(
                        this@MainActivity,
                        "Oops! Something went wrong: ${e::class.simpleName}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        ) {
            withContext(Dispatchers.IO) {
                gateway.getNearEarthObjects(
                    Calendar.getInstance(),
                    Calendar.getInstance().apply {
                        set(Calendar.DAY_OF_MONTH, get(Calendar.DAY_OF_MONTH) - 1)
                    }
                )
            }
                .let {
                    findViewById<TextView>(R.id.output).text = "Success!\n\n$it"
                }
        }
    }
}