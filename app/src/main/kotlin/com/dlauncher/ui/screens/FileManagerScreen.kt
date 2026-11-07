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
import com.dlauncher.ui.theme.*

data class FileEntry(
    val name: String,
    val size: String,
    val isFolder: Boolean,
    val icon: ImageVector = Icons.Default.Folder
)

@Composable
fun FileManagerScreen() {
    val leftItems = listOf(
        "Home" to Icons.Outlined.Home,
        "Internal Storage" to Icons.Outlined.Storage,
        "Downloads" to Icons.Outlined.Download,
        "Minecraft" to Icons.Outlined.Inventory2,
        "Screenshots" to Icons.Outlined.Image,
        "Backups" to Icons.Outlined.Backup,
        "Mods" to Icons.Outlined.Extension
    )

    val entries = listOf(
        FileEntry(".minecraft", "2.4 GB", true),
        FileEntry("games", "842 MB", true),
        FileEntry("mods", "1.2 GB", true),
        FileEntry("resourcepacks", "523 MB", true),
        FileEntry("shaderpacks", "378 MB", true),
        FileEntry("options.txt", "4 KB", false, Icons.Default.Description),
        FileEntry("servers.dat", "12 KB", false, Icons.Default.Description),
        FileEntry("screenshot.png", "2.1 MB", false, Icons.Default.Image),
        FileEntry("modpack.zip", "56 MB", false, Icons.Default.FolderZip),
        FileEntry("latest.log", "128 KB", false, Icons.Default.Code)
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
                    Icon(Icons.Default.Folder, null, tint = Color.White, modifier = Modifier.size(24.dp))
                }
                Spacer(Modifier.width(14.dp))
                Column {
                    Text("File Manager", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Browse, manage and organize your files.", color = Color.White.copy(0.8f), fontSize = 12.sp)
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        Row(Modifier.fillMaxSize()) {
            // Left side nav
            Column(
                modifier = Modifier
                    .width(180.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(CardBg)
                    .padding(8.dp)
            ) {
                leftItems.forEachIndexed { index, (label, icon) ->
                    val selected = index == 0
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (selected) SoftYellow else Color.Transparent)
                            .clickable { }
                            .padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            icon, null,
                            tint = if (selected) DeepOrange else TextSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            label,
                            fontSize = 13.sp,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            color = if (selected) TextPrimary else TextSecondary
                        )
                    }
                }
            }

            Spacer(Modifier.width(14.dp))

            // Main area
            Column(Modifier.weight(1f)) {
                // Toolbar
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(
                        "Back" to Icons.Default.ArrowBack,
                        "Up" to Icons.Default.ArrowUpward,
                        "New Folder" to Icons.Default.CreateNewFolder,
                        "New File" to Icons.Default.NoteAdd
                    ).forEach { (label, icon) ->
                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
                        ) {
                            Icon(icon, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text(label, fontSize = 12.sp)
                        }
                    }
                    Spacer(Modifier.weight(1f))
                    Text("4.8 GB / 12 GB", fontSize = 12.sp, color = TextMuted)
                }

                Spacer(Modifier.height(12.dp))

                // Grid
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(130.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(entries) { entry ->
                        FileCard(entry)
                    }
                }
            }
        }
    }
}

@Composable
fun FileCard(entry: FileEntry) {
    Card(
        modifier = Modifier
            .height(115.dp)
            .clickable { },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = entry.icon,
                contentDescription = null,
                tint = if (entry.isFolder) AccentOrange else TextSecondary,
                modifier = Modifier.size(34.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(entry.name, fontWeight = FontWeight.Medium, fontSize = 12.sp, maxLines = 1)
            Text(entry.size, fontSize = 11.sp, color = TextMuted)
        }
    }
}
