package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Libros;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
@CrossOrigin("*")
public class LibroController {

    @Autowired
    private  LibroService libroService;

    @PostMapping
    public Libros registrarLibro(Libros libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public Libros actualizarLibro(@PathVariable Long id , @RequestBody Libros libro) {
        Optional<Libros> libroExistente = libroService.buscarLibrosPorId(id);
        if (libroExistente.isPresent()) {
            libro.setId(id);
            return libroService.guardarLibro(libro);
        }else {
            throw new RuntimeException("Libro no encontrado");
        }

    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
         libroService.eliminarLibro(id);
    }
    @GetMapping("/buscar/titulo/{titulo}")
    public List<Libros> buscarPorTitulo(@PathVariable String titulo) {
        return libroService.buscarLibrosPorTitulo(titulo);
    }

    @GetMapping("/buscar/autor/{autor}")
    public List<Libros> buscarPorAutor(@PathVariable String autor) {
        return libroService.buscarLibrosPorAutor(autor);
    }
    @GetMapping("/buscar/isbn/{isbn}")
    public List<Libros> buscarPorIsbn(@PathVariable String isbn) {
        return libroService.buscarLibrosPorAutor(isbn);
    }

    @GetMapping("/{id}")
    public Optional<Libros> obtenerPorId(@PathVariable Long id) {
        return libroService.buscarLibrosPorId(id);
    }

    @GetMapping
    public List<Libros> obtenerTodos() {
        return libroService.buscarTodosLosLibros();
    }
}
