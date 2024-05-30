package mortum.vkbot.response

import mortum.vkbot.enums.Methods

class EchoRequest(params: Map<String, String?>,
) : Request(params, Methods.GET, null, null) {
}