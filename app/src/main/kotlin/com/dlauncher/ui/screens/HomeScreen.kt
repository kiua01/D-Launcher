package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlauncher.ui.theme.*

@Composable
fun HomeScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ===== LEFT / MAIN COLUMN =====
        Column(modifier = Modifier.weight(1f)) {
            // HERO BANNER (matches first screenshot)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .shadow(12.dp, RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color(0xFF2A0808),
                                Color(0xFF5C1212),
                                Color(0xFF3D0A0A),
                                Color(0xFF1A0505)
                            )
                        )
                    )
            ) {
                // Decorative elements to approximate Nether art
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-40).dp)
                        .size(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            Brush.radialGradient(
                                listOf(PortalPurple.copy(alpha = 0.6f), Color.Transparent)
                            )
                        )
                )

                // Left content
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 36.dp, end = 200.dp)
                ) {
                    Text(
                        "MINECRAFT",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 3.sp
                    )
                    Text(
                        "JAVA EDITION",
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 12.sp,
                        letterSpacing = 1.5.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "The End",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Black,
                        lineHeight = 42.sp
                    )
                    Text(
                        "awaits...",
                        color = Gold,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Black,
                        lineHeight = 42.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Face the Nether, explore new\nchallenges and discover more!",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )
                    Spacer(Modifier.height(18.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentOrange),
                        shape = RoundedCornerShape(50),
                        contentPadding = PaddingValues(horizontal = 28.dp, vertical = 12.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, null, modifier = Modifier.size(22.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Play Now", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }

                // Dots indicator
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(Modifier.size(7.dp).clip(CircleShape).background(Color.White))
                    repeat(4) {
                        Box(Modifier.size(7.dp).clip(CircleShape).background(Color.White.copy(0.35f)))
                    }
                }
            }

            Spacer(Modifier.height(22.dp))

            // Featured News header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Newspaper, null, tint = TextPrimary, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Featured News", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                }
                Text(
                    "View all →",
                    color = AccentOrange,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { }
                )
            }

            Spacer(Modifier.height(12.dp))

            // News cards
            LazyRow(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                items(
                    listOf(
                        NewsData("Spring to Life", "A fresh new look for Minecraft!", "Mar 25, 2025", listOf(Color(0xFFFFB7C5), Color(0xFFFF8FAB))),
                        NewsData("The Tricky Trials Update", "Take on new challenges!", "Jun 13, 2024", listOf(Color(0xFF60A5FA), Color(0xFF3B82F6))),
                        NewsData("Camel! Ride in Style", "Explore the desert with camels.", "Apr 3, 2024", listOf(Color(0xFFFBBF24), Color(0xFFF59E0B)))
                    )
                ) { news ->
                    NewsCard(news)
                }
            }
        }

        // ===== RIGHT COLUMN (What's New + Quick Links + Realms) =====
        Column(
            modifier = Modifier.width(280.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // What's New
            Card(
                modifier = Modifier.fillMaxWidth().height(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AutoAwesome, null, tint = AccentOrange, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("What's New?", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        }
                        Text("View all →", color = AccentOrange, fontSize = 11.sp, modifier = Modifier.clickable { })
                    }
                    Spacer(Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                Brush.horizontalGradient(listOf(Color(0xFF7C1D1D), Color(0xFF4A0E0E)))
                            )
                    )
                    Spacer(Modifier.height(10.dp))
                    Text("The Nether Update", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    Text("New biomes, new features!", fontSize = 12.sp, color = TextSecondary)
                    Spacer(Modifier.height(4.dp))
                    Text("Jun 30, 2024", fontSize = 11.sp, color = TextMuted)
                }
            }

            // Quick Links
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Link, null, tint = AccentOrange, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Quick Links", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                    Spacer(Modifier.height(12.dp))
                    val links = listOf(
                        "Official Website" to Icons.Default.Language,
                        "Patch Notes" to Icons.Default.Description,
                        "Discord" to Icons.Default.Chat,
                        "Marketplace" to Icons.Default.ShoppingCart,
                        "Skins" to Icons.Default.Checkroom,
                        "Gift Codes" to Icons.Default.CardGiftcard
                    )
                    links.chunked(3).forEach { row ->
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            row.forEach { (label, icon) ->
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable { }
                                        .padding(8.dp)
                                        .width(70.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(0xFFFFF1E0)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(icon, null, tint = DeepOrange, modifier = Modifier.size(18.dp))
                                    }
                                    Spacer(Modifier.height(4.dp))
                                    Text(label, fontSize = 10.sp, color = TextSecondary, maxLines = 1)
                                }
                            }
                        }
                        Spacer(Modifier.height(4.dp))
                    }
                }
            }

            // Join Realms
            Card(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.WorkspacePremium, null, tint = Gold, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Join Realms", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Play with friends anywhere, anytime!",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                    Spacer(Modifier.weight(1f))
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F1F1F)),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("Learn More →", color = Color.White, fontSize = 13.sp)
                    }
                }
            }
        }
    }
}

data class NewsData(val title: String, val desc: String, val date: String, val colors: List<Color>)

@Composable
fun NewsCard(news: NewsData) {
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(170.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Brush.horizontalGradient(news.colors))
            ) {
                Surface(
                    modifier = Modifier.padding(8.dp),
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White.copy(alpha = 0.9f)
                ) {
                    Text(
                        "News",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )
                }
            }
            Column(Modifier.padding(12.dp)) {
                Text(news.title, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
                Text(news.desc, fontSize = 11.sp, color = TextSecondary, maxLines = 1)
                Spacer(Modifier.height(6.dp))
                Text(news.date, fontSize = 10.sp, color = TextMuted)
            }
        }
    }
}
