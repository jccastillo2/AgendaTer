package com.Agenda.Agenda.repository

import com.Agenda.Agenda.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface usuarioRepository: JpaRepository<Usuario, Long> {
    fun findById (id:Long?):Usuario?
}