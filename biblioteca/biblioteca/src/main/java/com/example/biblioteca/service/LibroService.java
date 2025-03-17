package com.example.biblioteca.service;

import com.example.biblioteca.entity.Libros;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class LibroService {
    @Autowired
    private  LibroRepository libroRepository;


    public List<Libros> list(Libros libro) {
        return libroRepository.findAll();
    }
    public List<Libros> buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }
    public List<Libros> buscarPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }
    public List<Libros> buscarPorGenero(String genero) {
        return libroRepository.findByGenero(genero);
    }
    public Libros registrarLibro(Libros libro) {
        return libroRepository.save(libro);
    }
    public Optional<Libros> actualizarLibro(Long id, Libros libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setGenero(libroActualizado.getGenero());
            return libroRepository.save(libro);
        });
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

}
