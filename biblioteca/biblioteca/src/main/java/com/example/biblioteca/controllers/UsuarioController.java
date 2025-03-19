package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Usuarios;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuarios registrarUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuarios actualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
        Optional<Usuarios> usuarioExistente = usuarioService.obtenerPorId(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return usuarioService.guardarUsuario(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public List<Usuarios> buscarPorNombre(@PathVariable String nombre) {
        return usuarioService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/correo/{correo}")
    public Usuarios buscarPorCorreo(@PathVariable String correo) {
        return usuarioService.buscarPorCorreo(correo);
    }

    @PostMapping("/recuperar-contraseña")
    public String recuperarContraseña(@RequestBody String correo) {
        return usuarioService.recuperarContraseña(correo);
    }

    @GetMapping
    public List<Usuarios> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }
}
