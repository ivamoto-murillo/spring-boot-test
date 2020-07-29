package com.example.demo.transaction.manager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionManagerConfiguration {

    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager(
            @Qualifier("postgresTransactionManager") PlatformTransactionManager postgresTransactionManager,
            @Qualifier("mysqlTransactionManager") PlatformTransactionManager mysqlTransactionManager,
            @Qualifier("mongodbTransactionManager") PlatformTransactionManager mongodbTransactionManager) {
        return new ChainedTransactionManager(postgresTransactionManager, mysqlTransactionManager,
                mongodbTransactionManager);
    }

}
