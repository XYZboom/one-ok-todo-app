package io.github.xyzboom.oneoktodo.sync

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.xml.xml
import io.ktor.utils.io.core.toByteArray
import nl.adaptivity.xmlutil.serialization.XML
import kotlin.js.JsExport

@JsExport
class WebDavSynchronizer(
    private val baseUrl: String,
    private val username: String? = null,
    private val password: String? = null
) : ISynchronizer {
    companion object {
        private val webDavXml = XML {
            defaultPolicy {
                ignoreUnknownChildren()
            }
        }
    }

    private val client = HttpClient(CIO) {
        engine {
            https {}
        }
        install(ContentNegotiation) {
            xml(webDavXml)
        }
        if (username != null && password != null) {
            install(Auth) {
                basic {
                    credentials {
                        BasicAuthCredentials(
                            username = this@WebDavSynchronizer.username,
                            password = this@WebDavSynchronizer.password
                        )
                    }
                    sendWithoutRequest { true }
                }
            }
        }
        expectSuccess = true
    }

    @JsExport.Ignore
    override suspend fun push(fileName: String, content: String) {
        val contentArray = content.toByteArray()
        client.put(buildFullPath(fileName)) {
            setBody(contentArray)
            contentType(ContentType.Application.OctetStream)
            header("Content-Length", contentArray.size.toString())
            header("If-None-Match", "*")
        }
    }

    @JsExport.Ignore
    override suspend fun pull(fileName: String): String {
        TODO("Not yet implemented")
    }

    fun buildFullPath(fileName: String): String {
        val base = baseUrl.removeSuffix("/")
        val filePath = fileName.removePrefix("/")
        return if (filePath.isNotEmpty()) "$base/$filePath" else base
    }

}