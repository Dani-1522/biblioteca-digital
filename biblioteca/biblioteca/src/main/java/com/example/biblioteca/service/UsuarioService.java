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

    public Usuarios registrarUsuario(Usuarios usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())){
            throw new RuntimeException("El correo ya existe");
        }
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuarios> buscarUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
    public Optional<Usuarios> buscarUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

}
