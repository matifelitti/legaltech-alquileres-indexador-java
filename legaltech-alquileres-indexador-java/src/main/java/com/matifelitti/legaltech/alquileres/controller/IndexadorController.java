package com.matifelitti.legaltech.alquileres.controller;

import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import com.matifelitti.legaltech.alquileres.service.LectorCSVService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexadorController {

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        LectorCSVService lector = new LectorCSVService();
        List<IndicePrecios> listaIndices = lector.cargarIndices("data/indices.csv");
        
        model.addAttribute("listaIndices", listaIndices);
        
        return "index";
    }
}
