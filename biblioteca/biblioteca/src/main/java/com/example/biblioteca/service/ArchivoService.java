package com.example.biblioteca.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ArchivoService {
    private static final  String RUTA_ARCHIVO = "uploads/";

    public String guardarArchivo(MultipartFile archivo) throws IOException {
        String rutaCompleta = RUTA_ARCHIVO + archivo.getOriginalFilename();
        File directorio = new File(RUTA_ARCHIVO);
        if (!directorio.exists())
            directorio.mkdir();
        Files.write(Paths.get(rutaCompleta), archivo.getBytes());
        return rutaCompleta;
    }
}
