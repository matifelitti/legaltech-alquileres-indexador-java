package com.matifelitti.legaltech.alquileres.controller;

import com.matifelitti.legaltech.alquileres.model.Contrato;
import com.matifelitti.legaltech.alquileres.model.IndicePrecios;
import com.matifelitti.legaltech.alquileres.service.CalculadorService;
import com.matifelitti.legaltech.alquileres.service.LectorCSVService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexadorController {

    private final LectorCSVService lectorCSVService = new LectorCSVService();
    private final CalculadorService calculadorService = new CalculadorService();

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        List<IndicePrecios> listaIndices = lectorCSVService.cargarIndices("data/indices.csv");
        model.addAttribute("listaIndices", listaIndices);
        return "index";
    }

    // Ataja la petición POST enviada por el formulario HTML
    @PostMapping("/calcular")
    public String calcularIndexacion(
            @RequestParam("locatario") String locatario,
            @RequestParam("locador") String locador,
            @RequestParam("montoInicial") double montoInicial,
            @RequestParam("mesInicio") String mesInicio,
            @RequestParam("mesAjuste") String mesAjuste,
            Model model) {

        // 1. Cargamos los índices en memoria
        List<IndicePrecios> listaIndices = lectorCSVService.cargarIndices("data/indices.csv");

        // 2. Mapeamos un objeto Contrato temporal (usamos el primer día del mes elegido para la fecha)
        int anio = Integer.parseInt(mesInicio.substring(0, 4));
        int mes = Integer.parseInt(mesInicio.substring(5, 7));
        Contrato contrato = new Contrato(locatario, locador, montoInicial, LocalDate.of(anio, mes, 1), 3);

        // 3. Ejecutamos la fórmula matemática en nuestro servicio
        double montoActualizado = calculadorService.calcularAlquilerActualizado(contrato, listaIndices, mesAjuste);

        // 🔥 CONFIGURACIÓN: Puntos para miles, coma para centavos
        java.util.Locale localeArg = new java.util.Locale("es", "AR");
        java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(localeArg);
        java.text.DecimalFormat df = (java.text.DecimalFormat) nf;
        df.applyPattern("#,##0.00"); // Forzamos dos decimales fijos

        // Convertimos los números crudos a textos formateados con estilo local
        String montoInicialFormateado = df.format(montoInicial);
        String montoActualizadoFormateado = df.format(montoActualizado);
        
        // 4. Inyectamos las variables al HTML de salida
        model.addAttribute("locatario", locatario);
        model.addAttribute("locador", locador);
        model.addAttribute("montoInicial", montoInicialFormateado);
        model.addAttribute("mesInicio", mesInicio);
        model.addAttribute("mesAjuste", mesAjuste);
        model.addAttribute("montoActualizado", montoActualizadoFormateado);

        // 5. Redirigimos a la plantilla resultado.html
        return "resultado";
    }
}
