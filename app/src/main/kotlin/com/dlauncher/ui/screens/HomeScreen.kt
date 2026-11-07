package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlauncher.ui.theme.*

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Hero Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFF8B0000),
                            Color(0xFF4A0000),
                            Color(0xFF2D0A0A)
                        )
                    )
                )
        ) {
            // Overlay content
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(40.dp)
            ) {
                Text(
                    "MINECRAFT",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
                Text(
                    "JAVA EDITION",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    "The End",
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    "awaits...",
                    color = AccentYellow,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Black
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Face the Nether, explore new\nchallenges and discover more!",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = { /* Launch */ },
                    colors = ButtonDefaults.buttonColors(containerColor = SoftOrange),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.height(48.dp)
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Play Now", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
        
        Spacer(Modifier.height(24.dp))
        
        // Featured News
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Featured News", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDark)
            TextButton(onClick = {}) {
                Text("View all →", color = SoftOrange)
            }
        }
        
        Spacer(Modifier.height(12.dp))
        
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(listOf(
                Triple("Spring to Life", "A fresh new look for Minecraft!", "Mar 25, 2025"),
                Triple("The Tricky Trials Update", "Take on new challenges!", "Jun 13, 2024"),
                Triple("Camel! Ride in Style", "Explore the desert with camels.", "Apr 3, 2024")
            )) { (title, desc, date) ->
                NewsCard(title, desc, date)
            }
        }
        
        Spacer(Modifier.height(24.dp))
        
        // Quick side panels would go here in a more complex layout
        Row(Modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // What's New
            Card(
                modifier = Modifier.weight(1f).height(160.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardWhite)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("What's New?", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("The Nether Update", fontWeight = FontWeight.SemiBold)
                    Text("New biomes, new features!", fontSize = 13.sp, color = TextMuted)
                    Spacer(Modifier.weight(1f))
                    Text("Jun 30, 2024", fontSize = 12.sp, color = TextMuted)
                }
            }
            
            // Join Realms
            Card(
                modifier = Modifier.weight(1f).height(160.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardWhite)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Join Realms", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("Play with friends anywhere, anytime!", fontSize = 13.sp, color = TextMuted)
                    Spacer(Modifier.weight(1f))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = SoftOrange),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("Learn More →")
                    }
                }
            }
        }
    }
}

@Composable
fun NewsCard(title: String, description: String, date: String) {
    Card(
        modifier = Modifier.width(280.dp).height(160.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Brush.horizontalGradient(listOf(SoftOrange, DeepOrange)))
            )
            Spacer(Modifier.height(12.dp))
            Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1)
            Text(description, fontSize = 12.sp, color = TextMuted, maxLines = 1)
            Spacer(Modifier.weight(1f))
            Text(date, fontSize = 11.sp, color = TextMuted)
        }
    }
}
