package mortum.vkbot.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "send-message-url")
data class SendMessageURLConfig(
    var scheme: String,
    var host: String,
    var pathSegment: String,
    var apiVersion: String,
    var api_method: String
)