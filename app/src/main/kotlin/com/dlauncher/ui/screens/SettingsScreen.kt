package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlauncher.ui.theme.*

data class SettingsCategory(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val accent: Color
)

@Composable
fun SettingsScreen() {
    val categories = listOf(
        SettingsCategory("General", "App language, theme, and more.", Icons.Default.Monitor, AccentOrange),
        SettingsCategory("Minecraft", "Game settings and launch options.", Icons.Default.Cube, Color(0xFF22C55E)),
        SettingsCategory("Performance", "Allocate more resources for smoother gameplay.", Icons.Default.Speed, Color(0xFFF59E0B)),
        SettingsCategory("Downloads", "Manage downloads and cache.", Icons.Default.Download, Color(0xFF3B82F6)),
        SettingsCategory("Launcher Appearance", "Theme, colors, and interface style.", Icons.Default.Palette, Color(0xFFEC4899)),
        SettingsCategory("Miscellaneous Settings", "Various settings like UI, updates and more.", Icons.Default.Build, Color(0xFF8B5CF6)),
        SettingsCategory("Experimental Stuff", "Try experimental features and unsupported options.", Icons.Default.Science, Color(0xFF06B6D4)),
        SettingsCategory("Control Customization", "Customize keybinds, touch controls and layouts.", Icons.Default.SportsEsports, Color(0xFF84CC16))
    )

    Column(Modifier.fillMaxSize()) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF2A0808), Color(0xFF5C1212), Color(0xFF3D0A0A))
                    )
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(Modifier.padding(start = 24.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(AccentOrange),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Settings, null, tint = Color.White, modifier = Modifier.size(24.dp))
                }
                Spacer(Modifier.width(14.dp))
                Column {
                    Text("Settings", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Customize D Launcher Plus to match your style.", color = Color.White.copy(0.8f), fontSize = 12.sp)
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(categories) { cat ->
                SettingsCard(cat)
            }
        }
    }
}

@Composable
fun SettingsCard(cat: SettingsCategory) {
    Card(
        modifier = Modifier
            .height(105.dp)
            .clickable { },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            Modifier.fillMaxSize().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(cat.accent.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(cat.icon, null, tint = cat.accent, modifier = Modifier.size(24.dp))
            }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(cat.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = TextPrimary)
                Text(cat.description, fontSize = 11.5.sp, color = TextSecondary, maxLines = 2, lineHeight = 15.sp)
            }
            Icon(Icons.Default.ChevronRight, null, tint = TextMuted, modifier = Modifier.size(20.dp))
        }
    }
}
