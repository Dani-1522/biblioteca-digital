package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private String stok;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public void setId(Long id) {
        this.id = id;
    }
}
