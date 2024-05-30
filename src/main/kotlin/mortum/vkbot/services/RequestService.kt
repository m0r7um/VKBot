package mortum.vkbot.services

import mortum.vkbot.configuration.SendMessageURLConfig
import mortum.vkbot.configuration.TokenConfiguration
import mortum.vkbot.dto.Event
import mortum.vkbot.response.EchoRequest
import mortum.vkbot.senders.RequestSender
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Service


@Service
class RequestService(
    private val tokenConfiguration: TokenConfiguration,
    private val urlConfig: SendMessageURLConfig,
    private val requestSender: RequestSender
) : Logging {

    fun processRequest(event: Event): String {

        if (event.secret != tokenConfiguration.secret) {
            logger.error("Было получено сообщение с неправильным секретным ключом. " +
                    "Вместо ${tokenConfiguration.secret} -> ${event.secret}")
            return "error"
        }

        logger.info("Получено запрос: ${event.toJson()}")

        if (event.type == "confirmation") {

            return tokenConfiguration.confirmation

        } else if (event.type == "message_new") {

            val echoRequest = EchoRequest(
                params = mapOf(
                    "message" to "Вы сказали: ${event.Object.message.text}",
                    "user_id" to event.Object.message.from_id.toString(),
                    "access_token" to tokenConfiguration.access_key,
                    "v" to urlConfig.apiVersion,
                    "random_id" to "0"
                )
            )
            requestSender.sendRequest(echoRequest)
            logger.info("Был отправлен запрос с параметрами: ${echoRequest.params}")
        }

        return "ok"
    }

}