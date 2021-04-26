package net.upn.edu.pe.app.service;

import net.upn.edu.pe.app.dao.PacienteDao;
import net.upn.edu.pe.app.model.Paciente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PacienteImpl implements PacienteDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Paciente findByDni(String dni) {
        String sql = "SELECT * FROM paciente INNER JOIN persona WHERE paciente.dni_persona = persona.dni AND persona.dni =" + dni;
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Paciente> pacientes = jdbcTemplate.query(sql, new PacienteMapper());
        return pacientes.size() > 0 ? pacientes.get(0) : null;
    }

    @Override
    public List<Paciente> findAll() {
        String sql = "SELECT * FROM paciente INNER JOIN persona WHERE paciente.dni_persona = persona.dni";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new PacienteMapper());
    }

    @Override
    public int insert(Paciente paciente) {
        String sql = "INSERT INTO persona " +
                "(dni, apellidos, nombres, edad, sexo, estadoCivil, peso, talla, direccion, fechaNacimiento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, paciente.getDni(),paciente.getApellidos(),
                paciente.getNombres(), paciente.getEdad(), paciente.isSexo(), paciente.getEstadoCivil(),
                paciente.getPeso(), paciente.getTalla(), paciente.getDireccion(), paciente.getFechaNacimiento());
        sql = "INSERT INTO paciente (dni_persona, id_antecedente_clinico, id_historial_clinico) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, paciente.getDni(), 123, 123);
    }

    @Override
    public int update(Paciente paciente) {
        String sql = "UPDATE persona SET " +
                "dni = ?, apellidos = ?, nombres = ?, edad = ?, sexo = ?, estadoCivil = ?, peso = ?, " +
                "talla = ?, direccion = ?, fechaNacimiento = ? " +
                "WHERE dni = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.update(sql, paciente.getDni(),paciente.getApellidos(),
                paciente.getNombres(), paciente.getEdad(), paciente.isSexo(), paciente.getEstadoCivil(),
                paciente.getPeso(), paciente.getTalla(), paciente.getDireccion(), paciente.getFechaNacimiento(),
                paciente.getDni());
    }

    @Override
    public int delete(String dni) {
        String sql = "DELETE FROM paciente WHERE dni_persona = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, dni);
        sql = "DELETE FROM persona WHERE dni = ?";
        return jdbcTemplate.update(sql, dni);
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
                    "123",
                    null,
                    null
            );
        }
    }
}
