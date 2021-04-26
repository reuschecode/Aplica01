package net.upn.edu.pe.app.model;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona{

    private String idHistorial;
    private List<Consulta> historialClinico;
    private List<Antecedente> antecedentesClinicos;

    public Paciente() {
    }

    public Paciente(String dni, String apellidos, String nombres, int edad, boolean sexo, String estadoCivil, double peso, double talla, String direccion, Date fechaNacimiento, String idHistorial, List<Antecedente> antecendentesClinicos, List<Consulta> historialClinico) {
        super(dni, apellidos, nombres, edad, sexo, estadoCivil, peso, talla, direccion, fechaNacimiento);
        this.idHistorial = idHistorial;
        this.historialClinico = historialClinico;
        this.antecedentesClinicos = antecendentesClinicos;
    }

    public List<Consulta> getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(List<Consulta> historialClinico) {
        this.historialClinico = historialClinico;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public List<Antecedente> getAntecedentesClinicos() {
        return antecedentesClinicos;
    }

    public void setAntecedentesClinicos(List<Antecedente> antecedentesClinicos) {
        this.antecedentesClinicos = antecedentesClinicos;
    }
}
