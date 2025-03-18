package com.example.biblioteca.service;

import com.example.biblioteca.entity.Usuarios;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuarios> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Optional<Usuarios> buscarPorCorreo(String correo) {
        return usuarioRepository.findByEmail(correo);
    }

    public String recuperarContraseña(String correo) {
        Optional<Usuarios> usuario = usuarioRepository.findByEmail(correo);
        return usuario.map(value -> "Tu contraseña es: " + value.getPassword())
                .orElse("Correo no encontrado");
    }
}