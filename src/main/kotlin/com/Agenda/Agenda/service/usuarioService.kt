package com.Agenda.Agenda.service

import com.Agenda.Agenda.model.Usuario
import com.Agenda.Agenda.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class usuarioService {
    @Autowired
    lateinit var usuarioRepository: usuarioRepository


    fun list(): List<Usuario> {

        return usuarioRepository.findAll()
    }

    fun save(usuario:Usuario): Usuario {
        try {
            if (usuario.correo.equals("")){
                throw Exception("No se ha llenado el correo")
            }
            if (usuario.direccion.equals("")){
                throw Exception("No se ha llenado la direccion")
            }
            if (usuario.nombre.equals("")) {
                throw Exception("No se ha llenado el nombre")
            }else{
                return usuarioRepository.save(usuario)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
        }

    }
    fun update (usuario: Usuario):Usuario{
        return usuarioRepository.save(usuario)
    }

    fun updateDescription (usuario: Usuario): Usuario {
        val response = usuarioRepository.findById(usuario.id)
            ?: throw Exception()
        response.apply {
            this.id=usuario.id
        }
        return usuarioRepository.save(usuario)
    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }
}