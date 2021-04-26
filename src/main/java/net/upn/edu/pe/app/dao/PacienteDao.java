package net.upn.edu.pe.app.dao;

import net.upn.edu.pe.app.model.Paciente;

import java.util.List;

public interface PacienteDao {

    public int insert(Paciente paciente);
    public int update(Paciente paciente);
    public int delete(String dni);
    public Paciente findByDni(String dni);
    public List<Paciente> findAll();
}
