package mortum.vkbot.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.google.gson.Gson

data class Event(val type: String,
                 val groupId: Int,
                 val secret: String) {
    @JsonValue
    @JsonProperty("object")
    lateinit var Object: Object

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
