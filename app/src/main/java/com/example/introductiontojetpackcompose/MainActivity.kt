package com.example.introductiontojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introductiontojetpackcompose.ui.theme.IntroductionToJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .border(2.dp, Color.Cyan)
                            .padding(4.dp)
                            .background(Color.Red),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Greeting(name = "This")
                        Greeting(name = "is")
                        Greeting(name = "first")
                        Greeting(name = "column")
                    }

                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .border(2.dp, Color.Cyan)
                            .padding(4.dp)
                            .background(Color.Green),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Greeting(name = "This")
                        Greeting(name = "is")
                        Greeting(name = "Second")
                        Greeting(name = "column")
                    }
                }



                Row(
                    modifier = Modifier
                        .border(2.dp, Color.Magenta)
                        .padding(8.dp)
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .padding(4.dp)
                            .background(Color.Yellow),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Greeting(name = "This")
                        Greeting(name = "is")
                        Greeting(name = "second")
                        Greeting(name = "row")
                        Greeting(name = "first")
                        Greeting(name = "column")
                    }

                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .padding(4.dp)
                            .background(Color.Blue),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Greeting(name = "This")
                        Greeting(name = "is")
                        Greeting(name = "second")
                        Greeting(name = "row")
                        Greeting(name = "second")
                        Greeting(name = "column")
                    }
                }
            }

        }

    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroductionToJetPackComposeTheme {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Greeting(name = "This")
            Greeting(name = "is")
            Greeting(name = "a")
            Greeting(name = "Row")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Greeting(name = "This")
            Greeting(name = "is")
            Greeting(name = "a")
            Greeting(name = "column")
        }

    }
}