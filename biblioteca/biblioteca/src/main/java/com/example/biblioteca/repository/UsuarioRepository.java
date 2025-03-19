package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByNombre(String nombre);
    Optional<Usuarios> findByEmail(String email);
    List<Usuarios> findByNombreContainingIgnoreCase(String nombre);

    boolean existsByEmail(String correo);
}
