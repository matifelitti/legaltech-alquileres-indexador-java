package com.matifelitti.legaltech.alquileres.model;

public class IndicePrecios {
    
    private String mes;
    private double valor;

    public IndicePrecios(String mes, double valor) {
        this.mes = mes;
        this.valor = valor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
