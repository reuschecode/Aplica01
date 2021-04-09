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

    public Consulta(Date fecha, String movitoConsulta, String enfermedadActual, String antecedentes) {
        this.fecha = fecha;
        this.movitoConsulta = movitoConsulta;
        this.enfermedadActual = enfermedadActual;
        this.antecedentes = antecedentes;
    }
}
