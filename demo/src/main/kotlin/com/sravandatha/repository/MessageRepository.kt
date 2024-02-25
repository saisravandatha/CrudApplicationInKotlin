package com.sravandatha.repository

import com.sravandatha.Dto.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message,String> {

}