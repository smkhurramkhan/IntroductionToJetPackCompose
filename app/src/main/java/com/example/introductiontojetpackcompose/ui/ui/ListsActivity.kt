package com.example.introductiontojetpackcompose.ui.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ListsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                itemsIndexed(
                    listOf("this", "is", "jetpack", "compose")
                ) { index, string ->
                    Text(
                        text = string,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)

                    )
                }

            }
        }
    }
}
