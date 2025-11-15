package io.github.xyzboom.oneoktodo.utils

import androidx.compose.runtime.Composable
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.DayOfWeek.*
import one_ok_todo.composeapp.generated.resources.Res
import one_ok_todo.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource

@Composable
fun DayOfWeek.toReadableString(): String {
    return when (this) {
        MONDAY -> stringResource(Res.string.weekday_1)
        TUESDAY -> stringResource(Res.string.weekday_2)
        WEDNESDAY -> stringResource(Res.string.weekday_3)
        THURSDAY -> stringResource(Res.string.weekday_4)
        FRIDAY -> stringResource(Res.string.weekday_5)
        SATURDAY -> stringResource(Res.string.weekday_6)
        SUNDAY -> stringResource(Res.string.weekday_7)
    }
}
