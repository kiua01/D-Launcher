package com.dlauncher.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.dlauncher.ui.screens.*
import com.dlauncher.ui.theme.*

enum class Screen {
    Home, Installations, Skins, Marketplace, Settings, Account, FileManager, About
}

data class NavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
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

    Column(modifier = Modifier.fillMaxSize().background(CreamBg)) {
        // ========== TOP BAR (matches screenshots) ==========
        TopBar()

        Row(modifier = Modifier.fillMaxSize()) {
            // ========== SIDEBAR ==========
            Column(
                modifier = Modifier
                    .width(210.dp)
                    .fillMaxHeight()
                    .background(SidebarBg)
                    .padding(vertical = 12.dp, horizontal = 10.dp)
            ) {
                // Logo
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp, bottom = 20.dp)
                        .size(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Brush.linearGradient(listOf(AccentOrange, DeepOrange))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text("D", color = Color.White, fontWeight = FontWeight.Black, fontSize = 22.sp)
                }

                navItems.forEach { item ->
                    val selected = currentScreen == item.screen
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (selected) SoftYellow else Color.Transparent)
                            .clickable { currentScreen = item.screen }
                            .padding(horizontal = 14.dp, vertical = 11.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if (selected) item.selectedIcon else item.icon,
                            contentDescription = item.label,
                            tint = if (selected) DeepOrange else TextSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = item.label,
                            color = if (selected) TextPrimary else TextSecondary,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            fontSize = 13.5.sp
                        )
                    }
                }

                Spacer(Modifier.weight(1f))

                // Bottom user status (matches screenshots)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White.copy(alpha = 0.6f))
                        .padding(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(OnlineGreen)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text("Online", fontSize = 12.sp, color = TextSecondary, fontWeight = FontWeight.Medium)
                    }
                    Spacer(Modifier.height(4.dp))
                    Text("D Launcher", fontSize = 11.sp, color = TextMuted)
                    Text("v0.1.0", fontSize = 11.sp, color = TextMuted)
                }
            }

            // ========== CONTENT AREA ==========
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 4.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            ) {
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
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White.copy(alpha = 0.85f))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo + title area (left)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Brush.linearGradient(listOf(AccentOrange, DeepOrange))),
                contentAlignment = Alignment.Center
            ) {
                Text("D", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(Modifier.width(10.dp))
            Column {
                Text("D LAUNCHER", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = TextPrimary)
                Text("PLUS BY CRAFT STUDIO", fontSize = 9.sp, color = TextMuted, letterSpacing = 0.5.sp)
            }
        }

        Spacer(Modifier.width(24.dp))

        // Search bar (center)
        Box(
            modifier = Modifier
                .weight(1f)
                .height(38.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFF5F0E8))
                .border(1.dp, Color(0xFFE8E0D5), RoundedCornerShape(50))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Search, null, tint = TextMuted, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(10.dp))
                Text("Search for anything...", color = TextMuted, fontSize = 13.sp)
            }
        }

        Spacer(Modifier.width(16.dp))

        // Right actions
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // Notification
            Box {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Notifications, null, tint = TextSecondary)
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset((-6).dp, 6.dp)
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFEF4444)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("3", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
            }

            IconButton(onClick = {}) {
                Icon(Icons.Outlined.SportsEsports, null, tint = TextSecondary)
            }

            // User chip
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFF5F0E8))
                    .clickable { }
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(AccentOrange),
                    contentAlignment = Alignment.Center
                ) {
                    Text("K", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
                Spacer(Modifier.width(8.dp))
                Text("Kiua", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                Icon(Icons.Default.ArrowDropDown, null, tint = TextSecondary, modifier = Modifier.size(18.dp))
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
            Spacer(Modifier.height(8.dp))
            Text("Coming in next phase", color = TextMuted)
        }
    }
}
