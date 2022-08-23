package com.example.introductiontojetpackcompose.permissions

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState


@ExperimentalPermissionsApi
class ActivityPermissions : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val permissionState = rememberMultiplePermissionsState(
                permissions = listOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            )

            val lifeCycleOwner = LocalLifecycleOwner.current
            DisposableEffect(
                key1 = lifeCycleOwner,
                effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_START) {
                            permissionState.launchMultiplePermissionRequest()
                        }
                    }
                    lifeCycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifeCycleOwner.lifecycle.removeObserver(observer)
                    }
                }
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                permissionState.permissions.forEach { perm ->
                    when (perm.permission) {
                        Manifest.permission.CAMERA -> {
                            when {
                                perm.hasPermission -> {
                                    Text(text = "Camera Permission accepted")
                                }

                                perm.shouldShowRationale -> {
                                    Text(text = "Camera Permission is needed to use camera")
                                }

                                perm.isPermanentlyDenied() -> {
                                    Text(
                                        text = "Camera Permission denied. " +
                                                "You can enable it in app settings"
                                    )
                                }
                            }
                        }

                        Manifest.permission.READ_EXTERNAL_STORAGE -> {
                            when {
                                perm.hasPermission -> {
                                    Text(text = "storage Permission accepted")
                                }

                                perm.shouldShowRationale -> {
                                    Text(text = "Storage Permission is needed to use camera")
                                }

                                perm.isPermanentlyDenied() -> {
                                    Text(
                                        text = "Storage Permission denied. " +
                                                "You can enable it in app settings"
                                    )
                                }
                            }
                        }

                    }
                }

            }
        }
    }
}
