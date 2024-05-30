package mortum.vkbot

import mortum.vkbot.configuration.SendMessageURLConfig
import mortum.vkbot.configuration.TokenConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SendMessageURLConfig::class, TokenConfiguration::class)
class VkBotApplication

fun main(args: Array<String>) {
    runApplication<VkBotApplication>(*args)
}
