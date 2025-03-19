package com.example.biblioteca.service;

import com.example.biblioteca.entity.Recomendacion;
import com.example.biblioteca.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository ;

    public List<Recomendacion> obtenerReccomendacionesPorusuario(Long id_usuario) {
        return recomendacionRepository.findByUsuarioId(id_usuario);
    }
    public List<Recomendacion> obtenerReseñaPorLibro(Long id_libro) {
        return recomendacionRepository.findByLibroId(id_libro);
    }
    public Recomendacion guardarRecomendacion(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public List<Long> obtenerLibrosMasLeidos() {
        return recomendacionRepository.findAll().stream()
                .collect(Collectors.groupingBy(Recomendacion::getLibro, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e ->e.getKey().getId())
                .limit(10)
                .collect(Collectors.toList());
    }
}
