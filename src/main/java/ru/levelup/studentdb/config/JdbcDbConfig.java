package ru.levelup.studentdb.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JdbcDbConfig {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource(driver);
        datasource.setDriverClassName(driver);
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);

        return datasource;
    }

    // you can use NamedParameterJdbcTemplate or JdbcTemplate
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource datasource){
//        return new JdbcTemplate(datasource);
//    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
