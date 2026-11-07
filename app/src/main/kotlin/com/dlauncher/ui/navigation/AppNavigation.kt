package com.dlauncher.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlauncher.ui.screens.*
import com.dlauncher.ui.theme.*

enum class Screen {
    Home, Installations, Skins, Marketplace, Settings, Account, FileManager, About
}

data class NavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon
)

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(Screen.Home) }
    
    val navItems = listOf(
        NavItem(Screen.Home, "Home", Icons.Outlined.Home, Icons.Filled.Home),
        NavItem(Screen.Installations, "Installations", Icons.Outlined.Inventory2, Icons.Filled.Inventory2),
        NavItem(Screen.Skins, "Skins", Icons.Outlined.Checkroom, Icons.Filled.Checkroom),
        NavItem(Screen.Marketplace, "Marketplace", Icons.Outlined.ShoppingBag, Icons.Filled.ShoppingBag),
        NavItem(Screen.Settings, "Settings", Icons.Outlined.Settings, Icons.Filled.Settings),
        NavItem(Screen.Account, "Account", Icons.Outlined.Person, Icons.Filled.Person),
        NavItem(Screen.FileManager, "File Manager", Icons.Outlined.Folder, Icons.Filled.Folder),
        NavItem(Screen.About, "About", Icons.Outlined.Info, Icons.Filled.Info),
    )

    Row(modifier = Modifier.fillMaxSize().background(CreamBackground)) {
        // Sidebar
        Column(
            modifier = Modifier
                .width(220.dp)
                .fillMaxHeight()
                .background(Color.White.copy(alpha = 0.7f))
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(SoftOrange),
                contentAlignment = Alignment.Center
            ) {
                Text("D", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
            
            Spacer(Modifier.height(24.dp))
            
            navItems.forEach { item ->
                val selected = currentScreen == item.screen
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (selected) SidebarSelected else Color.Transparent)
                        .clickable { currentScreen = item.screen }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.icon,
                        contentDescription = item.label,
                        tint = if (selected) DeepOrange else TextMuted,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = item.label,
                        color = if (selected) TextDark else TextMuted,
                        fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
            
            Spacer(Modifier.weight(1f))
            
            // Status
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF4CAF50))
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Online", fontSize = 12.sp, color = TextMuted)
                }
                Text("D Launcher v0.1.0", fontSize = 11.sp, color = TextMuted)
            }
        }
        
        // Content
        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            when (currentScreen) {
                Screen.Home -> HomeScreen()
                Screen.Account -> AccountScreen()
                Screen.FileManager -> FileManagerScreen()
                Screen.Marketplace -> MarketplaceScreen()
                Screen.Settings -> SettingsScreen()
                Screen.Installations -> PlaceholderScreen("Installations")
                Screen.Skins -> PlaceholderScreen("Skins")
                Screen.About -> PlaceholderScreen("About D-Launcher")
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(title, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = TextDark)
    }
}
