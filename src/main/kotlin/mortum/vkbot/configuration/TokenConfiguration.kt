package mortum.vkbot.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tokens")
data class TokenConfiguration(var secret: String,
                              var confirmation: String,
                              var access_key: String
)

