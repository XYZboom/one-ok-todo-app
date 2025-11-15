package io.github.xyzboom.oneoktodo.sync

actual interface ISynchronizer {
    /**
     * @return true if push success
     */
    actual suspend fun push(fileName: String, content: String)

    actual suspend fun pull(fileName: String): String
}
