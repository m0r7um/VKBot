package mortum.vkbot.controllers

import mortum.vkbot.dto.Event
import mortum.vkbot.services.RequestService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/callback", produces = [APPLICATION_JSON_VALUE])
class Controller(var requestService: RequestService) {

    @PostMapping("/echo")
    fun sendEcho(@RequestBody event: Event): ResponseEntity<String> {

       return ResponseEntity.ok().body(requestService.processRequest(event))
    }
}