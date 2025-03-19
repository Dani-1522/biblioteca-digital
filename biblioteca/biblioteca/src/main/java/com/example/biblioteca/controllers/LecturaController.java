package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Lectura;
import com.example.biblioteca.service.LecturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectura")
@CrossOrigin("*")
public class LecturaController {

    @Autowired
    private LecturaService lecturaService;

    @PostMapping
    public Lectura registrarLectura(@RequestBody Lectura lectura) {
        return lecturaService.guardarLectura(lectura);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Lectura> obtenerLecturasPorUsuario(@PathVariable Long usuarioId) {
        return lecturaService.obtenerLecturas(usuarioId);
    }

    @PutMapping("/{id}")
    public Lectura actualizarLectura(@PathVariable Long id, @RequestBody Lectura lectura) {
        lectura.setId(id);
        return lecturaService.guardarLectura(lectura);
    }

    @DeleteMapping("/{id}")
    public void eliminarLectura(@PathVariable Long id) {
        lecturaService.eliminarLectura(id);
    }
}

