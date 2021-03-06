package net.upn.edu.pe.app.model;

import java.util.Date;

public class Noticia {
    private int id;
    private String titulo;
    private Date fecha;
    private String detalle;
    private String estatus;

    public Noticia(){
        this.fecha = new Date();
        this.estatus = "Activo";
    }

    public Noticia(int id, String titulo, Date fecha, String detalle, String estatus){
        super();
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.detalle = detalle;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
