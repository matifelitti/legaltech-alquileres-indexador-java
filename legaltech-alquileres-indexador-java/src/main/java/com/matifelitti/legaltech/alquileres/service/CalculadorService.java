package com.matifelitti.legaltech.alquileres.service;

import com.matifelitti.legaltech.alquileres.model.Contrato;
import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import java.util.List;

public class CalculadorService {

    // Método principal que ejecuta la fórmula de actualización indexada
    public double calcularAlquilerActualizado(Contrato contrato, List<IndicePrecios> listaIndices, String mesActualizacion) {
        double valorIndiceInicio = 0.0;
        double valorIndiceActualizacion = 0.0;
        
        // Convertimos la fecha de inicio del contrato al formato "YYYY-MM" del CSV
        String mesInicioContrato = contrato.getFechaInicio().toString().substring(0, 7);

        // Buscamos los valores de los índices para ambos meses en la lista en memoria
        for (IndicePrecios ind : listaIndices) {
            if (ind.getMes().equals(mesInicioContrato)) {
                valorIndiceInicio = ind.getValor();
            }
            if (ind.getMes().equals(mesActualizacion)) {
                valorIndiceActualizacion = ind.getValor();
            }
        }

        // Validación legal: Si falta algún índice, avisamos al usuario para no calcular mal
        if (valorIndiceInicio == 0.0) {
            System.err.println("⚠️ Alerta: No se encontró el índice para el mes de inicio: " + mesInicioContrato);
            return contrato.getMontoInicial();
        }
        if (valorIndiceActualizacion == 0.0) {
            System.err.println("⚠️ Alerta: No se encontró el índice para el mes de actualización: " + mesActualizacion);
            return contrato.getMontoInicial();
        }

        // 🔥 FÓRMULA MATEMÁTICA POST-DNU: (Monto Inicial * Indice Actual) / Indice Base
        double montoActualizado = (contrato.getMontoInicial() * valorIndiceActualizacion) / valorIndiceInicio;
        
        // Redondeamos a dos decimales para que parezca una liquidación real de caja
        return Math.round(montoActualizado * 100.0) / 100.0;
    }
}
