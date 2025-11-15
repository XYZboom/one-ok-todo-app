package io.github.xyzboom.oneoktodo.sync

actual fun getEnv(key: String): String? {
    return js("process.env[name]") as? String
}