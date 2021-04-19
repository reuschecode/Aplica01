package net.upn.edu.pe.app.service;

import net.upn.edu.pe.app.dao.PacienteDao;
import net.upn.edu.pe.app.model.Paciente;
import net.upn.edu.pe.app.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PacienteImpl implements PacienteDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Paciente paciente) {
    }

    @Override
    public void update(Paciente paciente) {

    }

    @Override
    public Paciente findByDni(String dni) {
        return null;
    }

    @Override
    public List<Paciente> findAll() {
        String sql = "SELECT * FROM paciente INNER JOIN persona WHERE paciente.dni_persona = persona.dni";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new PacienteMapper());
    }

    static class PacienteMapper implements RowMapper<Paciente> {
        public Paciente mapRow(ResultSet rs, int arg1) throws SQLException{
            return new Paciente(
                    rs.getString("dni"),
                    rs.getString("apellidos"),
                    rs.getString("nombres"),
                    rs.getInt("edad"),
                    rs.getBoolean("sexo"),
                    rs.getString("estadoCivil"),
                    rs.getDouble("peso"),
                    rs.getDouble("talla"),
                    rs.getString("direccion"),
                    rs.getDate("fechaNacimiento"),
                    rs.getString("id_historial_clinico"),
                    null,
                    null
            );
        }
    }
}
