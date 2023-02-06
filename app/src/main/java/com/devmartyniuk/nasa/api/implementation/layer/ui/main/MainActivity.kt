package com.devmartyniuk.nasa.api.implementation.layer.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devmartyniuk.nasa.api.implementation.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }
}