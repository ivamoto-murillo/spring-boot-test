package com.example.demo.transaction.manager.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.repository.mongodb")
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.mongodb.datasource.url}")
    private String mongoDbUrl;

    @Bean("mongodbTransactionManager")
    public MongoTransactionManager transactionManager(MongoDatabaseFactory databaseFactory) {
        return new MongoTransactionManager(databaseFactory);
    }

    @Override
    protected String getDatabaseName() {
        return this.mongoDbUrl.substring(this.mongoDbUrl.lastIndexOf("/") + 1);
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(this.mongoDbUrl);
    }

}
