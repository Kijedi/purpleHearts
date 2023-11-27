package com.langatt.flow.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.langatt.flow.models.CalendarUiModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.ChronoUnit
import java.util.stream.Collectors
import java.util.stream.Stream

@RequiresApi(Build.VERSION_CODES.O)
class CalendarDataSource {
    val today: LocalDate
        get() {
            return LocalDate.now()
        }
    fun getData(startDate: LocalDate = today, lastSelectedDate: LocalDate): CalendarUiModel {
        val monthLength = YearMonth.of(today.year, today.month).lengthOfMonth()
        val visibleDates = getDatesBetween(YearMonth.of(today.year, today.month).atDay(1), YearMonth.of(today.year, today.month).atDay(monthLength).plusDays(1))
        return toUiModel(visibleDates, lastSelectedDate)
    }

    private fun getDatesBetween(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
        val numOfDays = ChronoUnit.DAYS.between(startDate, endDate)
        return Stream.iterate(startDate) { date ->
            date.plusDays(/* daysToAdd = */ 1)
        }
            .limit(numOfDays)
            .collect(Collectors.toList())
    }

    private fun toUiModel(
        dateList: List<LocalDate>,
        lastSelectedDate: LocalDate
    ): CalendarUiModel {
        return CalendarUiModel(
            selectedDate = toItemUiModel(lastSelectedDate, true),
            visibleDates = dateList.map {
                toItemUiModel(it, it.isEqual(lastSelectedDate))
            },
        )
    }

    private fun toItemUiModel(date: LocalDate, isSelectedDate: Boolean) = CalendarUiModel.Date(
        isSelected = isSelectedDate,
        isToday = date.isEqual(today),
        date = date,
    )
}