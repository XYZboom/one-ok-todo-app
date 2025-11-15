package io.github.xyzboom.oneoktodo.sync

expect interface ISynchronizer {
    /**
     * @return true if push success
     */
    suspend fun push(fileName: String, content: String)

    suspend fun pull(fileName: String): String
}
