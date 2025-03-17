package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByCorreo(String email);
    Optional<Usuarios> findByNombre(String nombre);

    boolean existsByCorreo(String correo);
}
