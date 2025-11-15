package io.github.xyzboom.oneoktodo.sync

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
actual interface ISynchronizer {
    /**
     * @return true if push success
     */
    @JsExport.Ignore
    actual suspend fun push(fileName: String, content: String)

    @JsExport.Ignore
    actual suspend fun pull(fileName: String): String

    @JsName("push")
    fun promisePush(fileName: String, content: String): Promise<Unit> {
        return CoroutineScope(Dispatchers.Default).promise {
            push(fileName, content)
        }
    }

    @JsName("pull")
    fun promisePull(fileName: String): Promise<String> {
        return CoroutineScope(Dispatchers.Default).promise {
            pull(fileName)
        }
    }
}