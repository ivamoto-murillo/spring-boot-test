package com.example.demo.transaction.manager.postgres;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repository.postgres", entityManagerFactoryRef = "postgresEntityManagerFactory", transactionManagerRef = "postgresTransactionManager")
public class PostgresConfiguration {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Primary
    @Bean
    @ConfigurationProperties("spring.postgres.datasource")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource postgresDataSource(
            @Qualifier("postgresDataSourceProperties") DataSourceProperties postgresDataSourceProperties) {
        return postgresDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            @Qualifier("postgresDataSource") DataSource postgresDataSource, EntityManagerFactoryBuilder builder) {
        Map<String, Object> hibernateProperties = new HashMap<String, Object>();

        hibernateProperties.put("hibernate.hbm2ddl.auto", this.hibernateDdlAuto);

        return builder.dataSource(postgresDataSource).packages("com.example.demo.model.postgres")
                .persistenceUnit("postgres").properties(hibernateProperties).build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
        return new JpaTransactionManager(postgresEntityManagerFactory);
    }

}
