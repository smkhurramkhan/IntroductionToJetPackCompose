package com.example.introductiontojetpackcompose.navdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

class NavDrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    AppBar(onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    })
                },

                drawerContent = {
                    DrawerHeader()
                    DrawerBody(
                        items = listOf(
                            MenuItem(
                                id = "home",
                                title = "Home",
                                contentDescription = "Go to home screen",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "settings",
                                title = "Settings",
                                contentDescription = "Go to settings screen",
                                icon = Icons.Default.Settings
                            ),
                            MenuItem(
                                id = "help",
                                title = "Help",
                                contentDescription = "Go to help screen",
                                icon = Icons.Default.Info
                            ),
                        ),
                        onItemClick = {

                            when (it.id) {
                                "home" -> {
                                    println("clicked on ${it.title}")
                                }

                                "settings" -> {
                                    println("clicked on ${it.title}")
                                }

                                "help" -> {
                                    println("clicked on ${it.title}")
                                }
                            }

                        }
                    )
                }) {

            }
        }
    }
}
