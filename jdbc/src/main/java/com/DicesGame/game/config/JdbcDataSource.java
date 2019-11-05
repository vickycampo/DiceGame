package com.DicesGame.game.config;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDataSource
{

    private final String driverClassName = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/db_dicegame";
    private final String dbUsername = "root";
    private final String dbPassword = "root";
    public JdbcTemplate template;

    private DataSource dataSource;

    public JdbcDataSource() throws Exception
    {

        dataSource = getDataSource();
        //JdbcTemplate template = new JdbcTemplate(dataSource); // constructor
        this.template = new JdbcTemplate();
        this.template.setDataSource(dataSource);
        System.out.println(dataSource.getClass());


    }

    public DriverManagerDataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    public JdbcTemplate getTemplate()
    {
        return this.template;
    }
}
