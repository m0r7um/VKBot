package mortum.vkbot.response

import mortum.vkbot.enums.Methods

abstract class Request(val params: Map<String, String?>?,
                       val method: Methods,
                       val headers: Map<String, String?>?,
                       val body: Map<String, Any?>?)