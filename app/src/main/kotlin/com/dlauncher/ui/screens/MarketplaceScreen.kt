package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
    val rating: Float,
    val color: Color
)

@Composable
fun MarketplaceScreen() {
    val mods = listOf(
        ModItem("Xaero's Minimap", "A highly customizable minimap.", "12.8M", 4.8f, Color(0xFF34D399)),
        ModItem("Just Enough Items (JEI)", "View item recipes and more!", "20.1M", 4.9f, Color(0xFF60A5FA)),
        ModItem("Backpacked", "Carry more items!", "8.9M", 4.7f, Color(0xFFFBBF24)),
        ModItem("Complementary Shaders", "Stunning shaders for Minecraft.", "15.6M", 4.9f, Color(0xFFA78BFA)),
        ModItem("Smarter Furnace", "A smarter furnace for you!", "—", 4.6f, Color(0xFFF87171)),
        ModItem("Biomes O' Plenty", "Add more biomes to your world!", "—", 4.7f, Color(0xFF4ADE80)),
        ModItem("AppleSkin", "See food saturation values.", "—", 4.6f, Color(0xFFFB923C)),
        ModItem("FTB Quests", "Add quest system to your modpack.", "—", 4.8f, Color(0xFF818CF8))
    )

    Column(Modifier.fillMaxSize()) {
        // Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(105.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF2A0808), Color(0xFF5C1212), Color(0xFF3D0A0A))
                    )
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("MINECRAFT MOD STORE", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("Discover, download and install the best mods!", color = Color.White.copy(0.8f), fontSize = 12.sp)
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = AccentOrange),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Browse All →", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        // Categories
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val cats = listOf("All Mods", "Popular", "Client Mods", "Utility", "Gameplay", "Graphics", "Tech")
            cats.forEachIndexed { i, cat ->
                FilterChip(
                    selected = i == 0,
                    onClick = {},
                    label = { Text(cat, fontSize = 12.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = AccentOrange,
                        selectedLabelColor = Color.White,
                        containerColor = CardBg
                    ),
                    shape = RoundedCornerShape(50)
                )
            }
            Spacer(Modifier.weight(1f))
            Text("Sort by: Popular", fontSize = 12.sp, color = TextMuted)
        }

        Spacer(Modifier.height(14.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(210.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
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
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(mod.color.copy(alpha = 0.7f), mod.color.copy(alpha = 0.35f))
                        )
                    )
            ) {
                // Rating badge
                Surface(
                    modifier = Modifier.align(Alignment.TopEnd).padding(6.dp),
                    shape = RoundedCornerShape(6.dp),
                    color = Color.Black.copy(alpha = 0.55f)
                ) {
                    Row(
                        Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Star, null, tint = Gold, modifier = Modifier.size(12.dp))
                        Spacer(Modifier.width(2.dp))
                        Text("%.1f".format(mod.rating), color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(mod.name, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
            Text(mod.description, fontSize = 11.sp, color = TextSecondary, maxLines = 2, lineHeight = 14.sp)
            Spacer(Modifier.height(10.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("↓ ${mod.downloads}", fontSize = 11.sp, color = TextMuted)
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = AccentOrange),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 4.dp)
                ) {
                    Text("Install", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
