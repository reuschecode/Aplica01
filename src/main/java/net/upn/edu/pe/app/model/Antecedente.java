package net.upn.edu.pe.app.model;

import java.util.Date;

public class Antecedente {
    private int id;
    private Date fecha;
    private String motivoDeAtencion;
    private String operacion;
    private String estado;

    public Antecedente(Date fecha, String motivoDeAtencion, String operacion, String estado, int id) {
        this.id = id;
        this.fecha = fecha;
        this.motivoDeAtencion = motivoDeAtencion;
        this.operacion = operacion;
        this.estado = estado;
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

    public String getMotivoDeAtencion() {
        return motivoDeAtencion;
    }

    public void setMotivoDeAtencion(String motivoDeAtencion) {
        this.motivoDeAtencion = motivoDeAtencion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
