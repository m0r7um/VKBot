package mortum.vkbot.dto

data class Message(
    val date: Int,
    val from_id: Int,
    val id: Int,
    val text: String,
    val peer_id: Int
)
