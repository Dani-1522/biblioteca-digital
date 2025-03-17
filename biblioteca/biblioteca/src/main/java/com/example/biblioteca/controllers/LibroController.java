package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Libros;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libroS")
public class LibroController {

    @Autowired
    private  LibroService libroService;

    @PostMapping("/registrar")
    public ResponseEntity<Libros> registrarLibro(@RequestBody Libros libro) {
        return ResponseEntity.ok(libroService.registrarLibro(libro));
    }
    @GetMapping("/buscar")
    public List<Libros> listarLibros(Libros libro) {
        return libroService.list(libro);
    }
    @GetMapping("/buscar/titulo")
   public  ResponseEntity<List<Libros>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(titulo));
   }
    @GetMapping("/buscar/autor")
    public  ResponseEntity<List<Libros>> buscarPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(libroService.buscarPorAutor(autor));
    }
    @GetMapping("/buscar/genero")
    public  ResponseEntity<List<Libros>> buscarPorGenero(@RequestParam String genero) {
        return ResponseEntity.ok(libroService.buscarPorGenero(genero));
    }
    @PutMapping("/actualiza/{id}")
    public ResponseEntity<Libros> ActualizarLibro(@PathVariable Long id, @RequestBody Libros libroActualizado ) {
        return libroService.actualizarLibro(id, libroActualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
