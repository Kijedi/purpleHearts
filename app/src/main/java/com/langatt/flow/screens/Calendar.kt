package com.langatt.flow.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.langatt.flow.models.CalendarUiModel
import com.langatt.flow.utils.CalendarDataSource


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun CalendarPage() {
    CalendarApp(
        modifier = Modifier
            .fillMaxSize()
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        val dataSource = CalendarDataSource()
        // get CalendarUiModel from CalendarDataSource, and the lastSelectedDate is Today.
        val calendarUiModel = dataSource.getData(lastSelectedDate = dataSource.today)
        Column(modifier = modifier.fillMaxSize()) {
            Header(data = calendarUiModel)
            Spacer(modifier = Modifier.height(20.dp))
            Content(data = calendarUiModel)
        }
    }
}

@Composable
fun Header(data: CalendarUiModel) {
    Column {
        Text(
            text = "My Flow Calendar",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Row {
            Text(
                text = "MAY 2023",
                fontSize = 20.sp,
                letterSpacing = 2.sp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Previous"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next"
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Content(data: CalendarUiModel) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 50.dp)
    ) {
        items(items = data.visibleDates) { date ->
            ContentItem(date)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(date: CalendarUiModel.Date) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 4.dp),
        colors = CardDefaults.cardColors(
            // background colors of the selected date
            // and the non-selected date are different
            containerColor = if (date.isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.secondary
            }
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .padding(4.dp)
        ) {
            Text(
                letterSpacing = 2.sp,
                text = date.day, // day "Mon", "Tue"
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = date.date.dayOfMonth.toString(), // date "15", "16"
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

