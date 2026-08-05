package com.matifelitti.legaltech.alquileres.model;

import java.time.LocalDate;

public class Contrato {

    private String locatario;
    private String locador;
    private double montoInicial;
    private LocalDate fechaInicio;
    private int frecuenciaIndexacionMeses;

    public Contrato(String locatario, String locador, double montoInicial, LocalDate fechaInicio, int frecuenciaIndexacionMeses) {
        this.locatario = locatario;
        this.locador = locador;
        this.montoInicial = montoInicial;
        this.fechaInicio = fechaInicio;
        this.frecuenciaIndexacionMeses = frecuenciaIndexacionMeses;
    }

    public String getLocatario() {
        return locatario;
    }

    public void setLocatario(String locatario) {
        this.locatario = locatario;
    }

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFrecuenciaIndexacionMeses() {
        return frecuenciaIndexacionMeses;
    }

    public void setFrecuenciaIndexacionMeses(int frecuenciaIndexacionMeses) {
        this.frecuenciaIndexacionMeses = frecuenciaIndexacionMeses;
    }
}
