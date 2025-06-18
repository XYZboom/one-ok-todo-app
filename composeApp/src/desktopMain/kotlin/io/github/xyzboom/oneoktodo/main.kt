package io.github.xyzboom.oneoktodo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import io.github.xyzboom.oneoktodo.ui.HomeScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "one-ok-todo",
    ) {
        Navigator(HomeScreen)
    }
}