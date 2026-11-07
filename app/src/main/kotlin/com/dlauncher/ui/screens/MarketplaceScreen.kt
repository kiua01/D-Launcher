package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlauncher.ui.theme.*

data class ModItem(
    val name: String,
    val description: String,
    val downloads: String,
    val rating: Float
)

@Composable
fun MarketplaceScreen() {
    val mods = listOf(
        ModItem("Xaero's Minimap", "A highly customizable minimap.", "12.8M", 4.8f),
        ModItem("Just Enough Items (JEI)", "View item recipes and more!", "20.1M", 4.9f),
        ModItem("Backpacked", "Carry more items!", "8.9M", 4.7f),
        ModItem("Complementary Shaders", "Stunning shaders for Minecraft.", "15.6M", 4.9f),
        ModItem("Smarter Furnace", "A smarter furnace for you!", "—", 4.6f),
        ModItem("Biomes O' Plenty", "Add more biomes to your world!", "—", 4.7f),
        ModItem("AppleSkin", "See food saturation values.", "—", 4.6f),
        ModItem("FTB Quests", "Add quest system to your modpack.", "—", 4.8f)
    )
    
    Column(Modifier.fillMaxSize()) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Brush.horizontalGradient(listOf(Color(0xFF8B0000), Color(0xFF4A0000)))),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                Modifier.fillMaxWidth().padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("MINECRAFT MOD STORE", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Discover, download and install the best mods!", color = Color.White.copy(0.8f), fontSize = 13.sp)
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = SoftOrange),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Browse All →", fontWeight = FontWeight.Bold)
                }
            }
        }
        
        Spacer(Modifier.height(16.dp))
        
        // Categories
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("All Mods", "Popular", "Client Mods", "Utility", "Gameplay", "Graphics", "Tech").forEachIndexed { i, cat ->
                FilterChip(
                    selected = i == 0,
                    onClick = {},
                    label = { Text(cat) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = SoftOrange,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }
        
        Spacer(Modifier.height(16.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Adaptive(220.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(mods) { mod ->
                ModCard(mod)
            }
        }
    }
}

@Composable
fun ModCard(mod: ModItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Brush.linearGradient(listOf(SoftOrange.copy(0.3f), DeepOrange.copy(0.3f))))
            )
            Spacer(Modifier.height(10.dp))
            Text(mod.name, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1)
            Text(mod.description, fontSize = 12.sp, color = TextMuted, maxLines = 2)
            Spacer(Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("★ ${mod.rating}  ↓ ${mod.downloads}", fontSize = 11.sp, color = TextMuted)
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = SoftOrange),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Text("Install", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
