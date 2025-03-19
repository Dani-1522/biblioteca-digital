package com.example.biblioteca.controllers;

import com.example.biblioteca.component.JwtUtil;
import com.example.biblioteca.entity.Usuarios;
import com.example.biblioteca.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Usuarios regitrarUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PostMapping("/login")
    public Map<String, String> validarToken(@RequestBody Usuarios usuarios) {
        Usuarios usuariosBD = usuarioService.buscarPorCorreo(usuarios.getEmail());
        if (usuariosBD != null && new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().matches(usuarios.getPassword(), usuariosBD.getPassword())) {
            String token = jwtUtil.generarToken(usuarios.getEmail());
            return Map.of("token", token);
        }
        return Map.of("error", "Invalid email or password");
    }

}
