package com.matifelitti.legaltech.alquileres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexadorController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "index";
    }
}
