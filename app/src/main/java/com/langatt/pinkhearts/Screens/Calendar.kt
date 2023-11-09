package com.langatt.pinkhearts.Screens

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun CalendarPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCard(

            shape = CircleShape,
            elevation = CardDefaults.elevatedCardElevation(12.dp),
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Lutheal Phase",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Text(
                        text = "02",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "DAYS",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
//        insights()
    }
}

