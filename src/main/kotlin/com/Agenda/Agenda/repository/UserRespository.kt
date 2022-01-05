package com.Agenda.Agenda.repository

import com.Agenda.Agenda.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRespository: JpaRepository<User, Long> {
    fun findById (id: Long?): User?
    fun findByUsername (username: String?): User?
}