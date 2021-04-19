package net.upn.edu.pe.app.service;

import net.upn.edu.pe.app.dao.UsuarioDAO;
import net.upn.edu.pe.app.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioImpl implements UsuarioDAO {

    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(Usuario usuario) {
        String sql = "INSERT INTO usuarios " +
                "(nombres, apellidos, email, password, activo, telefono) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.update(sql, usuario.getNombres(), usuario.getApellidos(), usuario.getEmail(), usuario.getPassword(), true, usuario.getTelefono());
    }

    @Override
    public int update(Usuario usuario) {
        String sql = "UPDATE usuarios SET" +
                "nombres = ?, apellidos = ?, email = ?, password = ?, activo = ?, telefono = ? " +
                "WHERE id_usuario = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.update(sql, usuario.getNombres(), usuario.getApellidos(), usuario.getEmail(), usuario.getPassword(), usuario.isActivo(), usuario.getTelefono(), usuario.getId_usuario());
    }

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = "+id;
        jdbcTemplate = new JdbcTemplate(dataSource);
        ResultSetExtractor<Usuario> extractor = new ResultSetExtractor<Usuario>() {
            @Override
            public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    return new Usuario(rs.getInt("id_usuario"),
                                        rs.getString("nombres"),
                                        rs.getString("apellidos"),
                                        rs.getString("telefono"),
                                        rs.getString("email"),
                                        rs.getString("password"),
                                        rs.getBoolean("activo"));
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public Usuario validateUsuario(String email, String password) {
        String sql = "SELECT * FROM usuarios WHERE email = '"+email+"' AND password = '"+password+"'";
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Usuario> usuarios = jdbcTemplate.query(sql, new UsuarioMapper());
        return usuarios.size() > 0 ? usuarios.get(0) : null;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = "+ id;
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new UsuarioMapper());
    }

    static class UsuarioMapper implements RowMapper<Usuario>{
        public Usuario mapRow(ResultSet rs, int arg1) throws SQLException{
            return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getBoolean("activo")
            );
        }
    }
}
