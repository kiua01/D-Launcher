package com.dlauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
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
fun AccountScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF8B0000), Color(0xFF4A0000))
                    )
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(Modifier.padding(32.dp)) {
                Text(
                    "Account Type",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Choose how you want to play",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }
        
        Spacer(Modifier.height(32.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Offline Account Card
            AccountTypeCard(
                title = "Offline Account",
                description = "Play without signing in to Microsoft.",
                buttonText = "Select →",
                isRecommended = false,
                onClick = {}
            )
            
            // Microsoft Account Card
            AccountTypeCard(
                title = "Microsoft Account",
                description = "O Launcher recommends to play with it.",
                buttonText = "Sign In with Microsoft →",
                isRecommended = true,
                onClick = {}
            )
        }
    }
}

@Composable
fun RowScope.AccountTypeCard(
    title: String,
    description: String,
    buttonText: String,
    isRecommended: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.weight(1f).height(340.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar placeholder
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        if (isRecommended) Brush.verticalGradient(listOf(SoftOrange, DeepOrange))
                        else Brush.verticalGradient(listOf(Color(0xFF4FC3F7), Color(0xFF0288D1)))
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (!isRecommended) {
                    Icon(Icons.Default.WifiOff, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
                } else {
                    Text("MS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }
            
            Spacer(Modifier.height(20.dp))
            
            Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = TextDark)
            Spacer(Modifier.height(8.dp))
            Text(
                description,
                fontSize = 14.sp,
                color = TextMuted,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            
            if (isRecommended) {
                Spacer(Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(50),
                    color = SoftOrange.copy(alpha = 0.15f)
                ) {
                    Text(
                        "★ Recommended",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        color = DeepOrange,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            
            Spacer(Modifier.weight(1f))
            
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isRecommended) Color(0xFF4CAF50) else SoftOrange
                )
            ) {
                Text(buttonText, fontWeight = FontWeight.Bold)
            }
        }
    }
}
