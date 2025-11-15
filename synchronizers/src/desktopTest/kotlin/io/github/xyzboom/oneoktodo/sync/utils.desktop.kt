package io.github.xyzboom.oneoktodo.sync

actual fun getEnv(key: String): String? {
    return System.getenv(key)
}