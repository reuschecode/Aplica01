package net.upn.edu.pe.app.model;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona{

    private String id;
    private List<Consulta> historialClinico;

    public Paciente(String dni, String apellidos, String nombres, int edad, boolean sexo, String estadoCivil, float peso, float talla, String direccion, Date fechaNacimiento, List<Consulta> historialClinico) {
        super(dni, apellidos, nombres, edad, sexo, estadoCivil, peso, talla, direccion, fechaNacimiento);
        this.historialClinico = historialClinico;
    }

    public List<Consulta> getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(List<Consulta> historialClinico) {
        this.historialClinico = historialClinico;
    }
}
