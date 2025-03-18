package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Table(name = "usuarios")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(nullable = false)
    private Timestamp fecha_registro ;

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }
}
