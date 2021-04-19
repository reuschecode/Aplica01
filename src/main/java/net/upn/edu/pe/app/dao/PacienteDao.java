package net.upn.edu.pe.app.dao;

import net.upn.edu.pe.app.model.Paciente;

import java.util.List;

public interface PacienteDao {

    public void insert(Paciente paciente);
    public void update(Paciente paciente);
    public Paciente findByDni(String dni);
    public List<Paciente> findAll();
}
