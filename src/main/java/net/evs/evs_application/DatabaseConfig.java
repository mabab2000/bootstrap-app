package net.evs.evs_application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://dpg-d3d9psndiees738iljog-a.oregon-postgres.render.com:5432/evs");
        dataSource.setUsername("dev");
        dataSource.setPassword("iUIbHw6TrLF0Q4HvtkewfU2oleceISr2");
        return dataSource;
    }

}
