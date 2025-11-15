package io.github.xyzboom.oneoktodo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.kizitonwose.calendar.core.now
import io.github.xyzboom.oneoktodo.model.tasks.Task
import io.github.xyzboom.oneoktodo.model.tasks.TaskGroup
import io.github.xyzboom.oneoktodo.utils.toReadableString
import kotlinx.datetime.LocalDate
import one_ok_todo.composeapp.generated.resources.Res
import one_ok_todo.composeapp.generated.resources.home
import org.jetbrains.compose.resources.painterResource

object HomeScreen: Screen {
    @Suppress("unused")
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        val groups = listOf(
            TaskGroup("list 1", listOf(Task("task 1"), Task("task 2"))),
            TaskGroup("list 2", listOf(Task("task 1"), Task("task 2")))
        )
        MaterialTheme {
            LazyColumn(
                modifier = Modifier
                    .safeContentPadding()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    TimeWithIcon(modifier = Modifier.clickable {
                        // todo navigation is needed here
                    })
                }
                for (group in groups) {
                    item {
                        Text(group.name)
                    }
                    items(group.tasks, /*todo specify key*/) { task ->
                        TaskItem(task)
                    }
                }
            }
        }
    }
}

@Composable
fun TimeWithIcon(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            painterResource(Res.drawable.home), contentDescription = null,
            modifier = Modifier.height(40.dp)
        )
        LocalDataTimeText()
    }
}

@Composable
fun LocalDataTimeText() {
    val localDate = LocalDate.now()
    Column(modifier = Modifier.padding(start = 8.dp)) {
        Text(text = localDate.dayOfWeek.toReadableString())
        Text(text = localDate.toString())
    }
}