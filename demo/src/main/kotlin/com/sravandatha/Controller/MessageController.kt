package com.sravandatha.Controller

import com.sravandatha.Dto.Message
import com.sravandatha.Service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageController(val service:MessageService) {

    @GetMapping("/message")
    fun getMessages():List<Message>{
        return service.findMessages()
    }

    @GetMapping("/{id}")
    fun getMessageById(@PathVariable id:String): List<Message>{
        return service.findMessageById(id);
    }

    @PostMapping("/save")
    fun save(@RequestBody message: Message): String{
        return service.saveMessage(message)
    }

}