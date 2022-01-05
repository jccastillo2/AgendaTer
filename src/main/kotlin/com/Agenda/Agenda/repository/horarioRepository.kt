package com.Agenda.Agenda.repository

import com.Agenda.Agenda.model.Horario
import org.springframework.data.jpa.repository.JpaRepository

interface horarioRepository:JpaRepository<Horario, Long> {
    fun findById (id:Long?):Horario?
}