package com.example.demo.transaction.manager.mysql;

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repository.mysql", entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlTransactionManager")
public class MySqlConfiguration {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Bean
    @ConfigurationProperties("spring.mysql.datasource")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mysqlDataSource(
            @Qualifier("mysqlDataSourceProperties") DataSourceProperties mysqlDataSourceProperties) {
        return mysqlDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource mysqlDataSource, EntityManagerFactoryBuilder builder) {
        Map<String, Object> hibernateProperties = new HashMap<String, Object>();

        hibernateProperties.put("hibernate.hbm2ddl.auto", this.hibernateDdlAuto);

        return builder.dataSource(mysqlDataSource).packages("com.example.demo.model.mysql").persistenceUnit("mysql")
                .properties(hibernateProperties).build();
    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory mysqlEntityManagerFactory) {
        return new JpaTransactionManager(mysqlEntityManagerFactory);
    }

}
