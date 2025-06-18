package io.github.xyzboom.oneoktodo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.kizitonwose.calendar.core.now
import io.github.xyzboom.oneoktodo.Greeting
import io.github.xyzboom.oneoktodo.utils.toReadableString
import kotlinx.datetime.LocalDate
import one_ok_todo.composeapp.generated.resources.Res
import one_ok_todo.composeapp.generated.resources.compose_multiplatform
import one_ok_todo.composeapp.generated.resources.home
import org.jetbrains.compose.resources.painterResource

object HomeScreen: Screen {
    @Suppress("unused")
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        MaterialTheme {
            var showContent by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // todo: 添加点击此行的跳转逻辑
                TimeWithIcon()
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }
    }
}

@Composable
fun TimeWithIcon() {
    Row {
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