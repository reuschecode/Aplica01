package net.upn.edu.pe.app.dao;

import net.upn.edu.pe.app.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    public int insert(Usuario usuario);
    public int update(Usuario usuario);
    public Usuario findById(int id);
    public Usuario validateUsuario(String email, String password);
    public int delete(int id);
    public List<Usuario> findAll();
}
