package com.example.introductiontojetpackcompose.multiselectlazycolum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MultiSelectLazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var items by remember {
                mutableStateOf(
                    (1..20).map {
                        ListItem(
                            title = "Item is $it",
                            isSelected = false
                        )
                    }
                )
            }


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(items.size) { i ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            items = items.mapIndexed { j, item ->
                                if (i == j) {
                                    item.copy(isSelected = !item.isSelected)
                                } else item

                            }
                        }
                        .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(text = items[i].title)

                        if (items[i].isSelected) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Selected",
                                tint = Color.Green,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                    }
                }
            }
        }
    }
}
