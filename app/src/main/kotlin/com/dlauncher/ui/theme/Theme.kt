package com.dlauncher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colors inspired by O Launcher Plus screenshots
val CreamBackground = Color(0xFFFFF8F0)
val SoftOrange = Color(0xFFFFB347)
val DeepOrange = Color(0xFFFF8C00)
val AccentYellow = Color(0xFFFFD700)
val CardWhite = Color(0xFFFFFFF5)
val TextDark = Color(0xFF2D2D2D)
val TextMuted = Color(0xFF6B6B6B)
val SidebarSelected = Color(0xFFFFE4B5)
val NetherRed = Color(0xFF8B0000)
val PortalPurple = Color(0xFF9400D3)

private val LightColorScheme = lightColorScheme(
    primary = SoftOrange,
    onPrimary = Color.White,
    secondary = DeepOrange,
    onSecondary = Color.White,
    background = CreamBackground,
    surface = CardWhite,
    onBackground = TextDark,
    onSurface = TextDark,
    primaryContainer = SidebarSelected,
    secondaryContainer = Color(0xFFFFEFD5)
)

@Composable
fun DLauncherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography(),
        content = content
    )
}
