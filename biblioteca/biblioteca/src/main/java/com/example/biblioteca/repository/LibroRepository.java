package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libros, Long> {

    List<Libros> findByTitulo(String titulo);
    List<Libros> findByAutor(String autor);
    List<Libros> findByCategoria(String categoria);
    List<Libros> findByIsbn(String isbn);

}
