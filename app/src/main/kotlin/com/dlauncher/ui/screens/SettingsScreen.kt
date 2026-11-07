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
    val color: Color
)

@Composable
fun SettingsScreen() {
    val categories = listOf(
        SettingsCategory("General", "App language, theme, and more.", Icons.Default.Monitor, SoftOrange),
        SettingsCategory("Minecraft", "Game settings and launch options.", Icons.Default.Cube, Color(0xFF4CAF50)),
        SettingsCategory("Performance", "Allocate more resources for smoother gameplay.", Icons.Default.Speed, Color(0xFFFF9800)),
        SettingsCategory("Downloads", "Manage downloads and cache.", Icons.Default.Download, Color(0xFF2196F3)),
        SettingsCategory("Launcher Appearance", "Theme, colors, and interface style.", Icons.Default.Palette, Color(0xFFE91E63)),
        SettingsCategory("Miscellaneous Settings", "Various settings like UI, updates and more.", Icons.Default.Build, Color(0xFF9C27B0)),
        SettingsCategory("Experimental Stuff", "Try experimental features and unsupported options.", Icons.Default.Science, Color(0xFF00BCD4)),
        SettingsCategory("Control Customization", "Customize keybinds, touch controls and layouts.", Icons.Default.SportsEsports, Color(0xFF8BC34A))
    )
    
    Column(Modifier.fillMaxSize()) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Brush.horizontalGradient(listOf(Color(0xFF8B0000), Color(0xFF4A0000)))),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(Modifier.padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Settings, null, tint = SoftOrange, modifier = Modifier.size(36.dp))
                Spacer(Modifier.width(16.dp))
                Column {
                    Text("Settings", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Customize D Launcher Plus to match your style.", color = Color.White.copy(0.8f), fontSize = 13.sp)
                }
            }
        }
        
        Spacer(Modifier.height(20.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
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
            .height(110.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Row(
            Modifier.fillMaxSize().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(cat.color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(cat.icon, null, tint = cat.color, modifier = Modifier.size(26.dp))
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(cat.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(cat.description, fontSize = 12.sp, color = TextMuted, maxLines = 2)
            }
            Icon(Icons.Default.ChevronRight, null, tint = TextMuted)
        }
    }
}
