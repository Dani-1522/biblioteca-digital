package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Recomendacion;
import com.example.biblioteca.service.RecomendacionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {

    List<Recomendacion> findByUsuarioId(Long usuarioId);
    List<Recomendacion> findByLibroId(Long libroId);
}
