package com.langatt.pinkhearts

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.langatt.pinkhearts.Screens.CalendarPage
import com.langatt.pinkhearts.Screens.HomePage
import com.langatt.pinkhearts.Screens.ProfilePage
import com.langatt.pinkhearts.ui.theme.PinkHeartsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinkHeartsTheme {
                BottomNavigationExample()
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomNavigationExample() {
    val screens = listOf("Home", "Calendar", "Profile")
    var selectedScreen by remember { mutableStateOf(screens.first()) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(getIconForScreen(screen), contentDescription = screen) },
                        label = { Text(screen, style = MaterialTheme.typography.bodyLarge) },
                        selected = screen == selectedScreen,
                        onClick = { selectedScreen = screen }
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                ProfilePage(selectedScreen)
                getScreen(screen = selectedScreen)
            }
        }
    )
}

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Default.Home
        "Calendar" -> Icons.Default.DateRange
        "Profile" -> Icons.Default.Person
        else -> Icons.Default.Home
    }
}
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun getScreen(screen: String): Unit {
    return when (screen) {
        "Home" -> HomePage()
        "Calendar" -> CalendarPage()
        "Profile" -> ProfilePage(screen)
        else -> HomePage()
    }
}


