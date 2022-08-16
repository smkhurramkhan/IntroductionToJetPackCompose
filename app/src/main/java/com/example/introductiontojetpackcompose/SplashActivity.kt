package com.example.introductiontojetpackcompose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introductiontojetpackcompose.instaui.InstaUIActivity


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.ragnar)
            val title = getString(R.string.app_name)
            val description = getString(R.string.app_name)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                SplashCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }


        }


        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(
            {
                startActivity(
                    Intent(
                        this,
                        InstaUIActivity::class.java
                    )
                )
                finish()
            }, 3000
        )
    }
}

@Composable
fun SplashCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier

) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(1.dp),
        elevation = 5.dp
    ) {
        Box(modifier = modifier.fillMaxHeight()) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop

            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )

                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

    }
}





