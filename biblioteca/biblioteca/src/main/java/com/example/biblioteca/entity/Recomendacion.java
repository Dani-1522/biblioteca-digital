package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "recomendacion")
@AllArgsConstructor
@NoArgsConstructor
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libros libro;

    private double calificacion;
    private String reseña;

    public Long getId() {
        return id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public String getReseña() {
        return reseña;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public Libros getLibro() {
        return libro;
    }
}
