package com.testJava.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.testJava.repository"})
public class DataSourceConfig {

    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;
    @Value("${app.datasource.db}")
    private String db;
    @Value("${app.datasource.host}")
    private String host;
    @Value("${app.datasource.connector}")
    private String connector;
    private final HikariConfig config = new HikariConfig();

    @Bean(name = "dataSource")
    public DataSource customDataSource() {

        String url = connector + "://" + host + "/" + db;
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }
}
