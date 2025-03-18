package com.example.biblioteca.service;

import com.example.biblioteca.entity.Libros;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private  LibroRepository libroRepository;

    public List<Libros> buscarTodosLosLibros(){
        return libroRepository.findAll();
    }
    public Optional<Libros> buscarLibrosPorId(Long id){
        return libroRepository.findById(id);
    }

    public Libros guardarLibro(Libros libro){
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id){
        libroRepository.deleteById(id);
    }

    public List<Libros> buscarLibrosPorTitulo(String titulo){
        return libroRepository.findByTitulo(titulo);
    }
    public List<Libros> buscarLibrosPorAutor(String autor){
        return libroRepository.findByAutor(autor);
    }
    public List<Libros> buscarLibrosPorIsbn(String isbn){
        return libroRepository.findByIsbn(isbn);
    }
}
