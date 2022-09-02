package com.example.introductiontojetpackcompose.composepagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

class PaginationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val state = viewModel.state
            LazyColumn(modifier = Modifier.fillMaxSize()) {

            }
        }
    }
}
