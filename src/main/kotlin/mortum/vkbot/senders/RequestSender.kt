package mortum.vkbot.senders

import mortum.vkbot.configuration.SendMessageURLConfig
import mortum.vkbot.enums.Methods
import mortum.vkbot.response.Request
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Component

@Component
class RequestSender(private val urlConfig: SendMessageURLConfig) : Logging {

    fun sendRequest(rawRequest: Request): Response {
        val client = OkHttpClient()
        val request = createRequest(rawRequest)
        val response = client.newCall(request).execute()
        return response
    }

    private fun createRequest(request: Request): okhttp3.Request {
        val method = request.method

        return when (method)  {
            Methods.GET -> {
                parseGetRequest(request)
            }
            Methods.POST -> {
                // здесь должен вызываться метод parsePostRequest
                // данный кусок кода представлен как пример
                // для тестового задания достаточно GET запросов
                parseGetRequest(request)
            }
        }
    }

    private fun parseGetRequest(request: Request): okhttp3.Request {
        val URL = HttpUrl.Builder()
            .scheme(urlConfig.scheme)
            .host(urlConfig.host)
            .addPathSegment(urlConfig.pathSegment)
            .addPathSegment(urlConfig.api_method)
        if (request.params != null) {
            for ((name, param) in request.params) {

                URL.addQueryParameter(name, param)
            }
        }

        val req = okhttp3.Request.Builder()
            .url(URL.build())
            .build()

        return req
    }

//    private fun parsePostRequest(): Request {
//        логика парсинга POST запроса
//    }
}