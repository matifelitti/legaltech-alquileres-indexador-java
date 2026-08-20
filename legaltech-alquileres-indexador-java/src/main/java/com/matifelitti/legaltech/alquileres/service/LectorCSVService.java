package com.matifelitti.legaltech.alquileres.service;

import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSVService {

    public List<IndicePrecios> cargarIndices(String rutaArchivo) {
        List<IndicePrecios> listaIndices = new ArrayList<>();
        String linea;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            br.readLine(); 
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if (datos.length == 2) {
                    String mes = datos[0].trim();
                    double valor = Double.parseDouble(datos[1].trim()); // Convertimos el texto a número
                    
                    listaIndices.add(new IndicePrecios(mes, valor));
                }
            }
            System.out.println("✅ Se cargaron con éxito " + listaIndices.size() + " registros de índices.");
            
        } catch (IOException e) {
            System.err.println("❌ Error crítico al leer el archivo de índices: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("❌ Error: Formato numérico inválido en el CSV: " + e.getMessage());
        }

        return listaIndices;
    }
}
