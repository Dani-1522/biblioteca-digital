package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "lecturas")
@AllArgsConstructor
@NoArgsConstructor
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuaio_id", nullable = false)
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false )
    private Libros libro;
    private String marcadores;

    public void setId(Long id) {
        this.id = id;
    }
}
