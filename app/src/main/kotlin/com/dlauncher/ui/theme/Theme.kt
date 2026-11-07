package com.dlauncher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Exact color palette extracted from O Launcher Plus screenshots
val CreamBg = Color(0xFFFFF7ED)           // warm cream background
val CardBg = Color(0xFFFFFFF8)            // almost white cards
val SoftYellow = Color(0xFFFFE4A3)        // selected sidebar
val AccentOrange = Color(0xFFFFB347)      // main orange buttons
val DeepOrange = Color(0xFFFF9F1C)        // deeper orange
val Gold = Color(0xFFFFD700)
val TextPrimary = Color(0xFF1F1F1F)
val TextSecondary = Color(0xFF6B7280)
val TextMuted = Color(0xFF9CA3AF)
val OnlineGreen = Color(0xFF22C55E)
val NetherDark = Color(0xFF2A0A0A)
val NetherRed = Color(0xFF7C1D1D)
val PortalPurple = Color(0xFF7B2CBF)
val SidebarBg = Color(0xFFFFFBF5)

val NetherGradient = Brush.horizontalGradient(
    listOf(Color(0xFF3D0A0A), Color(0xFF5C1212), Color(0xFF2A0808))
)

val HeroGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFF4A0E0E),
        Color(0xFF6B1515),
        Color(0xFF3A0A0A)
    )
)

private val LightScheme = lightColorScheme(
    primary = AccentOrange,
    onPrimary = Color.White,
    secondary = DeepOrange,
    onSecondary = Color.White,
    background = CreamBg,
    surface = CardBg,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    primaryContainer = SoftYellow,
    surfaceVariant = Color(0xFFFFF1E0),
    outline = Color(0xFFE5E0D8)
)

@Composable
fun DLauncherTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightScheme,
        typography = Typography(),
        content = content
    )
}
