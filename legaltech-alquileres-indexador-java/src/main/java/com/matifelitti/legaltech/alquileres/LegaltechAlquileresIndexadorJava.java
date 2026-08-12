package com.matifelitti.legaltech.alquileres;

import com.matifelitti.legaltech.alquileres.model.Contrato;
import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import com.matifelitti.legaltech.alquileres.service.CalculadorService;
import com.matifelitti.legaltech.alquileres.service.LectorCSVService;
import java.time.LocalDate;
import java.util.List;

public class LegaltechAlquileresIndexadorJava {

    public static void main(String[] args) {
        System.out.println("🏛️ Sistema LegalTech - Indexador de Alquileres Comerciales");
        System.out.println("---------------------------------------------------------");
        
        // 1. Cargamos los índices desde el archivo unificado
        LectorCSVService lector = new LectorCSVService();
        List<IndicePrecios> listaIndices = lector.cargarIndices("data/indices.csv");
        
        // 2. Simulamos la firma de un contrato de locación comercial post-DNU
        // Locatario: "Empresa S.A.", Locador: "Propietario SRL", Monto: $500.000, Inicio: 2026-01-01, Ajuste: cada 3 meses
        Contrato contratoComercial = new Contrato(
            "Empresa S.A.", 
            "Propietario SRL", 
            500000.0, 
            LocalDate.of(2026, 1, 1), 
            3
        );
        
        // 3. Inicializamos el cerebro matemático y calculamos al cuarto mes (Abril)
        CalculadorService calculador = new CalculadorService();
        String mesDeActualizacion = "2026-04";
        
        double nuevoMonto = calculador.calcularAlquilerActualizado(contratoComercial, listaIndices, mesDeActualizacion);

        // 4. Imprimimos el dictamen de liquidación por consola
        System.out.println("\n📜 --- DICTAMEN DE LIQUIDACIÓN DE LOCACIÓN ---");
        System.out.println("• Locatario: " + contratoComercial.getLocatario());
        System.out.println("• Locador: " + contratoComercial.getLocador());
        System.out.println("• Fecha de Inicio: " + contratoComercial.getFechaInicio());
        System.out.println("• Alquiler Base Inicial: $" + contratoComercial.getMontoInicial());
        System.out.println("• Período de Ajuste Aplicado: " + mesDeActualizacion);
        System.out.println("=========================================================");
        System.out.println("💰 NUEVO CANON LOCATIVO ACTUALIZADO: $" + nuevoMonto);
        System.out.println("=========================================================");
    }
}
