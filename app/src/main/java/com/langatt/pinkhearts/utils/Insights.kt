package com.langatt.pinkhearts.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Insights(name: String, icon: ImageVector, value: String) {
    object Pregnancy : Insights("Chance of Pregancy", Icons.Outlined.Face, "12")
    object Starts : Insights("Period starts on", Icons.Outlined.Face, "14. Dec")
    object Fertile : Insights("Fertile Phase starts on", Icons.Outlined.Face, "14. Dec")
}