package io.github.xyzboom.oneoktodo.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.xyzboom.oneoktodo.model.tasks.Task

@Composable
fun TaskItem(task: Task) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
    ) {
        Text(text = task.name)
    }
}