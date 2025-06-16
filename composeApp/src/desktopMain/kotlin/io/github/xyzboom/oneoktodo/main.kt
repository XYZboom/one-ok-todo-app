package io.github.xyzboom.oneoktodo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "one-ok-todo",
    ) {
        App()
    }
}