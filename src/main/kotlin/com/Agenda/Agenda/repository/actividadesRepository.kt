package com.Agenda.Agenda.repository

import com.Agenda.Agenda.model.Actividades
import org.springframework.data.jpa.repository.JpaRepository

interface actividadesRepository: JpaRepository<Actividades, Long> {
    fun findById (id:Long?):Actividades?
}