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
import androidx.compose.runtime.*
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

data class FileItem(val name: String, val size: String, val isFolder: Boolean, val icon: ImageVector = Icons.Default.Folder)

@Composable
fun FileManagerScreen() {
    var currentPath by remember { mutableStateOf("Home") }
    
    val folders = listOf(
        FileItem(".minecraft", "2.4 GB", true),
        FileItem("games", "842 MB", true),
        FileItem("mods", "1.2 GB", true),
        FileItem("resourcepacks", "523 MB", true),
        FileItem("shaderpacks", "378 MB", true)
    )
    
    val files = listOf(
        FileItem("options.txt", "4 KB", false, Icons.Default.Description),
        FileItem("servers.dat", "12 KB", false, Icons.Default.Description),
        FileItem("screenshot.png", "2.1 MB", false, Icons.Default.Image),
        FileItem("modpack.zip", "56 MB", false, Icons.Default.Archive),
        FileItem("latest.log", "128 KB", false, Icons.Default.Code)
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
                Icon(Icons.Default.Folder, contentDescription = null, tint = SoftOrange, modifier = Modifier.size(36.dp))
                Spacer(Modifier.width(16.dp))
                Column {
                    Text("File Manager", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Browse, manage and organize your files.", color = Color.White.copy(0.8f), fontSize = 13.sp)
                }
            }
        }
        
        Spacer(Modifier.height(16.dp))
        
        // Toolbar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = {}) { Icon(Icons.Default.ArrowBack, null, Modifier.size(18.dp)); Spacer(Modifier.width(4.dp)); Text("Back") }
            OutlinedButton(onClick = {}) { Icon(Icons.Default.ArrowUpward, null, Modifier.size(18.dp)); Spacer(Modifier.width(4.dp)); Text("Up") }
            Spacer(Modifier.width(8.dp))
            OutlinedButton(onClick = {}) { Icon(Icons.Default.CreateNewFolder, null, Modifier.size(18.dp)); Spacer(Modifier.width(4.dp)); Text("New Folder") }
            OutlinedButton(onClick = {}) { Icon(Icons.Default.NoteAdd, null, Modifier.size(18.dp)); Spacer(Modifier.width(4.dp)); Text("New File") }
            Spacer(Modifier.weight(1f))
            Text("Storage: 4.8 GB / 12 GB", fontSize = 13.sp, color = TextMuted)
        }
        
        Spacer(Modifier.height(16.dp))
        
        // Content grid
        LazyVerticalGrid(
            columns = GridCells.Adaptive(140.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(folders + files) { item ->
                FileCard(item)
            }
        }
    }
}

@Composable
fun FileCard(item: FileItem) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .clickable { },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = if (item.isFolder) SoftOrange else TextMuted,
                modifier = Modifier.size(36.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(item.name, fontWeight = FontWeight.Medium, fontSize = 13.sp, maxLines = 1)
            Text(item.size, fontSize = 11.sp, color = TextMuted)
        }
    }
}
