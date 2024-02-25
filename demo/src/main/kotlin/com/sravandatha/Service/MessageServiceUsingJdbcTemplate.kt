package com.sravandatha.Service

import com.sravandatha.Dto.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MessageServiceUsingJdbcTemplate(val db: JdbcTemplate) {

    fun findMessages(): List<Message>{

        return db.query("select * from messages") { response, _ ->
            Message(
                response.getString("id"),
                response.getString("text")
            )
        }
    }

    fun saveMessage(message: Message): String{

        // The below line explains if message.id is not null then  message.id else generate a random UUID
        val id = message.id ?: UUID.randomUUID().toString()

        db.update("insert into messages values (? , ?)", id, message.text)

        return "Inserted Successfully"
    }

    fun findMessageById(id:String):List<Message> {

        return db.query("select * from messages where id = ?",id) {
            response, _ -> Message(
            response.getString("id"),
            response.getString("text"))
        }

    }

}