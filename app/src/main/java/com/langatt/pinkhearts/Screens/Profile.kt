package com.langatt.pinkhearts.Screens

import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
        Text(text = "Profile page", style = MaterialTheme.typography.titleLarge)
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Name") },
                singleLine = true
            )
            Button(
                modifier = Modifier.padding(vertical = 20.dp),
                onClick = { showDatePicker = !showDatePicker },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Pick Date")
            }
            if(showDatePicker){
                DateRangePicker(state = state)
            }

        }
    }
}

