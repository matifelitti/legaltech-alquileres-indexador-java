package com.matifelitti.legaltech.alquileres.controller;

import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import com.matifelitti.legaltech.alquileres.service.LectorCSVService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexadorController {

    @GetMapping("/api/indices")
    public List<IndicePrecios> obtenerIndices() {
        LectorCSVService lector = new LectorCSVService();
        return lector.cargarIndices("data/indices.csv");
    }

    @GetMapping("/api/saludo")
    public String saludar(@RequestParam(value = "nombre", defaultValue = "Mati") String nombre) {
        return "🏛️ ¡Hola " + nombre + "! El motor LegalTech ya está conectado a Spring Boot.";
    }
}
