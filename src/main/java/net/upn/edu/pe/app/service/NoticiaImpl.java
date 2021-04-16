package net.upn.edu.pe.app.service;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class NoticiaImpl {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

}
