package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.mongodb.Audit;
import com.example.demo.model.mysql.Car;
import com.example.demo.model.postgres.User;
import com.example.demo.repository.mongodb.AuditRepository;
import com.example.demo.repository.mysql.CarRepository;
import com.example.demo.repository.postgres.UserRepository;

@Service
public class GeneralService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuditRepository auditRepository;

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabases() throws Exception {
        this.userRepository.save(new User("Murillo", false));
        this.carRepository.save(new Car("Palio", false));
        this.auditRepository.save(new Audit("FUNFOU!!!", false));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabasesExceptionPostgres() throws Exception {
        this.userRepository.save(new User("Murillo Exception", true));
        this.carRepository.save(new Car("Palio Exception", false));
        this.auditRepository.save(new Audit("FUNFOU Exception!!!", false));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabasesExceptionMySql() throws Exception {
        this.userRepository.save(new User("Murillo Exception", false));
        this.carRepository.save(new Car("Palio Exception", true));
        this.auditRepository.save(new Audit("FUNFOU Exception!!!", false));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabasesExceptionMongoDb() throws Exception {
        this.userRepository.save(new User("Murillo Exception", false));
        this.carRepository.save(new Car("Palio Exception", false));
        this.auditRepository.save(new Audit("FUNFOU Exception!!!", true));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabasePostgresChained() throws Exception {
        this.userRepository.save(new User("Murillo Postgres Chained", false));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabaseMySqlChained() throws Exception {
        this.carRepository.save(new Car("Palio MySql Chained", false));
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabaseMongoDbChained() throws Exception {
        this.auditRepository.save(new Audit("FUNFOU MongoDB Chained!!!", false));
    }

    @Transactional(value = "postgresTransactionManager")
    public void saveInDatabasePostgres() throws Exception {
        this.userRepository.save(new User("Murillo Postgres", false));
    }

    @Transactional(value = "mysqlTransactionManager")
    public void saveInDatabaseMySql() throws Exception {
        this.carRepository.save(new Car("Palio MySql", false));
    }

    @Transactional(value = "mongodbTransactionManager")
    public void saveInDatabaseMongoDb() throws Exception {
        this.auditRepository.save(new Audit("FUNFOU MongoDB!!!", false));
    }

}
