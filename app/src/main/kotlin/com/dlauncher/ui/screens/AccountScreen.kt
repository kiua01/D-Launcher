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
import androidx.compose.ui.draw.shadow
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
                .height(130.dp)
                .shadow(8.dp, RoundedCornerShape(18.dp))
                .clip(RoundedCornerShape(18.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF2A0808), Color(0xFF5C1212), Color(0xFF3D0A0A))
                    )
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(Modifier.padding(start = 32.dp)) {
                Text(
                    "Account Type",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Choose how you want to play",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        Spacer(Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Offline
            AccountCard(
                title = "Offline Account",
                description = "Play without signing in\nto Microsoft.",
                buttonText = "Select →",
                buttonColor = AccentOrange,
                isRecommended = false,
                avatarGradient = listOf(Color(0xFF38BDF8), Color(0xFF0EA5E9))
            )

            // Microsoft
            AccountCard(
                title = "Microsoft Account",
                description = "O Launcher recommends\nto play with it.",
                buttonText = "Sign In with Microsoft →",
                buttonColor = Color(0xFF22C55E),
                isRecommended = true,
                avatarGradient = listOf(AccentOrange, DeepOrange)
            )
        }
    }
}

@Composable
fun RowScope.AccountCard(
    title: String,
    description: String,
    buttonText: String,
    buttonColor: Color,
    isRecommended: Boolean,
    avatarGradient: List<Color>
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .height(380.dp)
            .shadow(6.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Brush.verticalGradient(avatarGradient)),
                contentAlignment = Alignment.Center
            ) {
                if (!isRecommended) {
                    Icon(
                        Icons.Default.WifiOff,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                } else {
                    // Microsoft-like square
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("MS", fontWeight = FontWeight.Bold, color = Color(0xFF00A4EF), fontSize = 16.sp)
                    }
                }
            }

            Spacer(Modifier.height(22.dp))

            Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = TextPrimary)
            Spacer(Modifier.height(8.dp))
            Text(
                description,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 18.sp
            )

            if (isRecommended) {
                Spacer(Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(50),
                    color = SoftYellow
                ) {
                    Text(
                        "★  O Launcher recommends to play with it.",
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        color = DeepOrange,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text(buttonText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }
    }
}
