package com.devmartyniuk.nasa.api.implementation.layer.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.devmartyniuk.nasa.api.implementation.R

class ActivityMain : AppCompatActivity() {
    private val viewModel: ViewModelMain by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory)[ViewModelMain::class.java]
    }

    private val output by lazy {
        findViewById<TextView>(R.id.output)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main)

        viewModel.errorData.observe(this) {
            it?.let { output.text = "Error: ${it::class.simpleName}" }
        }

        viewModel.isInProgressData.observe(this) {
            if (it) output.text = "Loading..."
        }

        viewModel.nearEarthObjectsData.observe(this) {
            output.text = "Loaded. Count: ${it.count()}"
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.onViewReady()
    }
}