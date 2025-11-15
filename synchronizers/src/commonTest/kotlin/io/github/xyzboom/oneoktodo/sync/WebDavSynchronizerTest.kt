package io.github.xyzboom.oneoktodo.sync

import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class WebDavSynchronizerTest {
    val webdavUrl = getEnv("oot.webdav.url")
        ?: throw NullPointerException("Please set env oot.webdav.url")
    val username = getEnv("oot.webdav.username")
        ?: throw NullPointerException("Please set env oot.webdav.username")
    val password = getEnv("oot.webdav.password")
        ?: throw NullPointerException("Please set env oot.webdav.password")

    @Test
    fun func() {
        val webDavSynchronizer = WebDavSynchronizer(webdavUrl, username, password)
        runTest {
            webDavSynchronizer.push("oneoktodo/test.txt", "aaaa")
        }
    }
}