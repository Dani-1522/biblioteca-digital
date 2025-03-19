package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "usuarios")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Rol> roles = new HashSet<>();

    @Column(nullable = false)
    private Timestamp fecha_registro ;

    public void setId(Long id_usuario) {
        this.id = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getEmail() {
        return email;
    }
}
