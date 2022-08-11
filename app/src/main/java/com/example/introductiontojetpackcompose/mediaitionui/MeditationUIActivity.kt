package com.example.introductiontojetpackcompose.mediaitionui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MeditationUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}