@file:Suppress("DEPRECATION")

package com.xkanuk.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // deprecated, replaced by code in styles.xml
        // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}