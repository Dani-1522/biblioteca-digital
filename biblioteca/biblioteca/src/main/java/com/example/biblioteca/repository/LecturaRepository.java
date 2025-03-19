package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Lectura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Long> {
    List<Lectura> findByUsuarioId(Long id_usuario);
    Lectura findByUsuarioIdAndLibroId(Long usuarioId, Long libroId);
}
