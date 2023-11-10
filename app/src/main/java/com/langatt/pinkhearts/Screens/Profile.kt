package com.langatt.pinkhearts.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ProfilePage() {
    var text by rememberSaveable { mutableStateOf("Jane Doe") }
    var showDatePicker by remember {
        mutableStateOf(false)
    }
    val state = rememberDateRangePickerState()
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "My Data",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp)
        ) {
            TextField(
                readOnly = true,
                value = text,
                textStyle = MaterialTheme.typography.displaySmall,
                onValueChange = { text = it },
                label = { Text("Nickname") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                enabled = false,
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.White
                )
//                value= "Jane Doe"
            )
            ElevatedCard(
                shape = RoundedCornerShape(8.dp), modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Period Start Data",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "12 Dec 2023",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 14.sp
                        )
                    }
                    ElevatedButton(
                        modifier = Modifier.padding(vertical = 20.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(12.dp),
                        onClick = { showDatePicker = !showDatePicker },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Adjust Date", style = MaterialTheme.typography.labelSmall)
                    }
                }

            }
            ElevatedCard(
                shape = RoundedCornerShape(8.dp), modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Period End Data",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "18 Dec 2023",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 14.sp
                        )
                    }
                    ElevatedButton(
                        modifier = Modifier.padding(vertical = 20.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(12.dp),
                        onClick = { showDatePicker = !showDatePicker },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Adjust Date", style = MaterialTheme.typography.labelSmall)
                    }
                }

            }

            if (showDatePicker) {
                OutlinedCard(
                    modifier = Modifier.fillMaxHeight(0.5f),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.elevatedCardElevation(12.dp)
                ) {
                    DateRangePicker(
                        modifier = Modifier.scale(0.8F),
                        state = state,
                        title = { Text(text = "Period Dates") })
                }
            }
            Box(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)) {
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape= RoundedCornerShape(8.dp),
                    colors=ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(10.dp)
//                        .fillMaxWidth()
//                        .align(alignment = Alignment.CenterHorizontally)
                ) {
                    Text(text = "Save Changes", style=MaterialTheme.typography.displaySmall, color = Color.White)
                }
            }
        }
    }
}



