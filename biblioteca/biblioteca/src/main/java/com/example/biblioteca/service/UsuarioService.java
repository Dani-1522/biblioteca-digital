package com.example.biblioteca.service;

import com.example.biblioteca.entity.Usuarios;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuarios guardarUsuario(Usuarios usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuarios> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Usuarios buscarPorCorreo(String correo) {
        return usuarioRepository.findByEmail(correo).orElse(null);
    }

    public String recuperarContraseña(String correo) {
        Optional<Usuarios> usuario = usuarioRepository.findByEmail(correo);
        return usuario.map(value -> "Tu contraseña es: " + value.getPassword())
                .orElse("Correo no encontrado");
    }
}