package com.sravandatha.Service

import com.sravandatha.Dto.Message
import com.sravandatha.repository.MessageRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val repository: MessageRepository) {

    fun findMessages():List<Message>{
        return repository.findAll().toList()
    }

    fun findMessageById(id: String): List<Message>{
        return repository.findById(id).toList()
    }

    fun saveMessage(message: Message): String{
        repository.save(message)
        return "Inserted Successfully"
    }

    /*
    * Extension functions
    The return type of the findById() function in the CrudRepository interface is an instance of the Optional class.
    * However, it would be convenient to return a List with a single message for consistency.
    * For that, you need to unwrap the Optional value if it’s present, and return a list with the value.
    * This can be implemented as an extension function to the Optional type.

    In the code, Optional<out T>.toList(), .toList() is the extension function for Optional.
    * Extension functions allow you to write additional functions to any classes,
    * which is especially useful when you want to extend functionality of some library class.
    * */
    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}