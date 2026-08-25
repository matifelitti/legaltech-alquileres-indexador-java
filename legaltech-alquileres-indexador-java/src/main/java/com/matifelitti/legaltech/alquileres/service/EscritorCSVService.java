package com.matifelitti.legaltech.alquileres.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EscritorCSVService {

    public void registrarLiquidacion(String rutaArchivo, String locatario, String locador, String mesInicio, String montoInicial, String mesAjuste, String montoActualizado) {
        File archivo = new File(rutaArchivo);
        boolean elArchivoEsNuevo = !archivo.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            
            // Si el archivo no existía, se crea la fila
            if (elArchivoEsNuevo) {
                bw.write("Fecha_Registro,Locatario,Locador,Mes_Inicio,Monto_Inicial,Mes_Ajuste,Monto_Actualizado");
                bw.newLine();
            }

            // Captura de la fecha y hora exacta del momento de la consulta
            String fechaHoraActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Armado de la línea del CSV limpiando comas internas de los nombres por seguridad
            String linea = String.format("%s,%s,%s,%s,%s,%s,%s",
                    fechaHoraActual,
                    locatario.replace(",", " "),
                    locador.replace(",", " "),
                    mesInicio,
                    montoInicial.replace(".", ""), // Guardamos el número limpio sin puntos de miles visuales
                    mesAjuste,
                    montoActualizado.replace(".", "")
            );

            bw.write(linea);
            bw.newLine();
            System.out.println("💾 Liquidación de " + locatario + " guardada con éxito en el historial.");

        } catch (IOException e) {
            System.err.println("❌ Error al escribir el historial: " + e.getMessage());
        }
    }
}