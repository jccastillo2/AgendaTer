package com.Agenda.Agenda.Controller

import com.Agenda.Agenda.model.Usuario
import com.Agenda.Agenda.service.usuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class usuarioController {
    @Autowired
    lateinit var UsuarioService: usuarioService

    @GetMapping
    fun list(): List<Usuario>{
        return UsuarioService.list()
    }
    @PostMapping
    fun  save (@RequestBody usuario: Usuario):Usuario{
        return UsuarioService.save(usuario)
    }
    @PutMapping
    fun update (@RequestBody usuario: Usuario): Usuario{
        return UsuarioService.update(usuario)
    }

    @PatchMapping
    fun updateDescription (@RequestBody usuario: Usuario): Usuario {
        return UsuarioService.updateDescription(usuario)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return UsuarioService.delete(id)
    }
}