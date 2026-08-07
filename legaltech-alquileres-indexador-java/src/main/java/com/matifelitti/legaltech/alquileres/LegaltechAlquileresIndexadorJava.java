package com.matifelitti.legaltech.alquileres;

import com.matifelitti.legaltech.alquileres.service.LectorCSVService;

public class LegaltechAlquileresIndexadorJava {

    public static void main(String[] args) {
        System.out.println("🏛️ Iniciando el motor de indexación contractual...");
        
        LectorCSVService lector = new LectorCSVService();
        
        // Llamamos al lector apuntando a la carpeta data que creamos la otra vez
        lector.cargarIndices("data/indices.csv");
    }
}
