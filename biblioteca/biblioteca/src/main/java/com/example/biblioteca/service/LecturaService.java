package com.example.biblioteca.service;

import com.example.biblioteca.entity.Lectura;
import com.example.biblioteca.repository.LecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturaService {
    @Autowired
    private LecturaRepository lecturaRepository;

    public List<Lectura> obtenerLecturas(Long usuarioId) {
       return lecturaRepository.findByUsuarioId(usuarioId);
    }
    public Lectura guardarLectura(Lectura lectura) {
        return lecturaRepository.save(lectura);
    }
    public Lectura obtenerLectura(Long usuaioId, Long lecturaId) {
        return lecturaRepository.findByUsuarioIdAndLibroId(usuaioId, lecturaId);
    }
    public void eliminarLectura(Long id) {
        lecturaRepository.deleteById(id);
    }

}
