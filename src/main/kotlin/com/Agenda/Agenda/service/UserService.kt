package com.Agenda.Agenda.service

import com.Agenda.Agenda.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException
import com.Agenda.Agenda.repository.UserRespository

@Service

class UserService {
    @Autowired
    lateinit var userRepository: UserRespository


    fun list(): List<User> {
        return userRepository.findAll()
    }

    fun getUser (username:String?):User? {
        try {
            val response = userRepository.findByUsername(username)
                ?: throw Exception("No existe usuario")
            return response
        } catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update (@RequestBody user: User): User {
        return userRepository.save(user)
    }

}