package com.example.biblioteca.controllers;

import com.example.biblioteca.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/archivo")
@CrossOrigin("*")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    public ResponseEntity<String> subirArchivo(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String ruta = archivoService.guardarArchivo(archivo);
            return ResponseEntity.ok("Archivo guardado en ruta"+ruta);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar archivo");
        }

    }
}
