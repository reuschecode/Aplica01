package net.upn.edu.pe.app.model;

import java.util.Date;

public class Consulta {
    private int id;
    private Date fecha;
    private String movitoConsulta;
    private String enfermedadActual;
    private String antecedentes;
    private double peso;
    private int talla;

    public Consulta(Date fecha, String movitoConsulta, String enfermedadActual, String antecedentes, double peso, int talla, int id) {
        this.fecha = fecha;
        this.movitoConsulta = movitoConsulta;
        this.enfermedadActual = enfermedadActual;
        this.antecedentes = antecedentes;
        this.peso = peso;
        this.talla = talla;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMovitoConsulta() {
        return movitoConsulta;
    }

    public void setMovitoConsulta(String movitoConsulta) {
        this.movitoConsulta = movitoConsulta;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }
}
