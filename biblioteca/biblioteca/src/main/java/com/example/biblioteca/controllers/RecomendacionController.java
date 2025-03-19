package com.example.biblioteca.controllers;

import com.example.biblioteca.entity.Recomendacion;
import com.example.biblioteca.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomendaciones")
@CrossOrigin("*")
public class RecomendacionController {
    @Autowired
    private  RecomendacionService recomendacionService;



    @PostMapping
    public Recomendacion registrarRecomendacion(@RequestBody Recomendacion recomendacion) {
        return recomendacionService.guardarRecomendacion(recomendacion);
    }
    @GetMapping("/usuario/{idUsuario}")
    public List<Recomendacion> obtenerRecomendacionPorUsuario(@PathVariable Long idUsuario) {
        return recomendacionService.obtenerReccomendacionesPorusuario(idUsuario);
    }
    @GetMapping("/libro/{idLibro}")
    public List<Recomendacion> obtenerRecomendacionPorLibro(@PathVariable Long idLibro) {
        return recomendacionService.obtenerReseñaPorLibro(idLibro);
    }
    @GetMapping("/populares")
    public List<Long> obtenerLibroMasLeidos() {
        return recomendacionService.obtenerLibrosMasLeidos();
    }

}
