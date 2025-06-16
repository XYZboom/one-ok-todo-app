package io.github.xyzboom.oneoktodo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform