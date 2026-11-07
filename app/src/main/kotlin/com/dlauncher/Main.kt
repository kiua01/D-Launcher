package com.dlauncher

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.dlauncher.ui.navigation.AppNavigation
import com.dlauncher.ui.theme.DLauncherTheme

fun main() = application {
    val windowState = rememberWindowState(width = 1280.dp, height = 800.dp)
    
    Window(
        onCloseRequest = ::exitApplication,
        title = "D Launcher - Minecraft Java Edition",
        state = windowState
    ) {
        DLauncherTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                AppNavigation()
            }
        }
    }
}
