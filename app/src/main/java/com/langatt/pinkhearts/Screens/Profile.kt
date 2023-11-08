package com.langatt.pinkhearts.Screens

import android.widget.DatePicker
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(screen: String) {
    var text by rememberSaveable { mutableStateOf("") }
    var showDatePicker by remember {
        mutableStateOf(false)
    }
    val state = rememberDateRangePickerState()
    Column {
        Text(text = "$screen Page", style = MaterialTheme.typography.titleLarge)
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Name") },
                singleLine = true
            )
            ElevatedButton(
                modifier = Modifier.padding(vertical = 20.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(12.dp),
                onClick = { showDatePicker = !showDatePicker },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Pick Date", style = MaterialTheme.typography.bodyLarge)
            }
            if(showDatePicker){
                OutlinedCard(
                    modifier= Modifier.fillMaxHeight(0.5f),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.elevatedCardElevation(12.dp)
                ) {
                    DateRangePicker(modifier = Modifier.scale(0.8F), state = state, title = {Text(text = "Period Dates")})
                }
            }
        }
    }
}

