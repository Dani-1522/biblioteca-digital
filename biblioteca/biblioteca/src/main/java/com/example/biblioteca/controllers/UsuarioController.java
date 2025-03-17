package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Usuarios;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private  UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuarios registrarUsuario(Usuarios usuario) {
        return usuarioService.registrarUsuario(usuario);
    }
    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    @GetMapping("/nombre/{correo}")
    public Optional<Usuarios> obtenerUsuarioPorcorreo(@PathVariable String correo) {
        return usuarioService.buscarUsuarioPorCorreo(correo);
    }
    @GetMapping("/nombre/{nombre}")
    public Optional<Usuarios> obtenerUsuarioPorNombre(@PathVariable String nombre) {
        return usuarioService.buscarUsuarioPorNombre(nombre);
    }
}
