package com.langatt.pinkhearts.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.langatt.pinkhearts.R

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
@Preview
fun HomePage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
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
        insights()
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun insights() {
    val items = listOf("Period", "Pregnancy")
    Column(modifier = Modifier.padding(vertical = 40.dp, horizontal = 10.dp)) {
        InsightData("Chance of Pregancy", R.drawable.period2, "12%", MaterialTheme.colorScheme.secondary)
        InsightData("Period starts on", R.drawable.period, "14. Dec", MaterialTheme.colorScheme.secondary)
        InsightData("Fertile Phase starts on", R.drawable.period3, "14. Dec", MaterialTheme.colorScheme.secondary)
    }
}

@Composable
fun InsightText(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun InsightData(name: String, icon: Int, value: String, iconColor: Color){
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,) {
                Image(
                    painterResource(icon),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(horizontal = 8.dp).width(30.dp).height(30.dp)
                )
                InsightText(name, MaterialTheme.typography.bodyLarge)
            }
            InsightText(value, MaterialTheme.typography.labelSmall)
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Divider(thickness = 0.5.dp)
    }

}