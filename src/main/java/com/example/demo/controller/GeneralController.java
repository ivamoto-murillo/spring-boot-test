package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GeneralService;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/save")
    public String save() {
        try {
            this.generalService.saveInDatabases();
        } catch (Exception ex) {
            return "ERRO AO SALVAR!!!";
        }

        return "SUCESSO AO SALVAR!!!";
    }

    @GetMapping("/saveExceptionPostgres")
    public String saveInDatabasesExceptionPostgres() {
        try {
            this.generalService.saveInDatabasesExceptionPostgres();
        } catch (Exception ex) {
            return "ERRO AO SALVAR!!!";
        }

        return "SUCESSO AO SALVAR!!!";
    }

    @GetMapping("/saveExceptionMySql")
    public String saveInDatabasesExceptionMySql() {
        try {
            this.generalService.saveInDatabasesExceptionMySql();
        } catch (Exception ex) {
            return "ERRO AO SALVAR!!!";
        }

        return "SUCESSO AO SALVAR!!!";
    }

    @GetMapping("/saveExceptionMongoDb")
    public String saveInDatabasesExceptionMongoDb() {
        try {
            this.generalService.saveInDatabasesExceptionMongoDb();
        } catch (Exception ex) {
            return "ERRO AO SALVAR!!!";
        }

        return "SUCESSO AO SALVAR!!!";
    }

    @GetMapping("/savePostgresChained")
    public String saveInDatabasePostgresChained() {
        try {
            this.generalService.saveInDatabasePostgresChained();
        } catch (Exception ex) {
            return "ERRO AO SALVAR POSTGRES CHAINED!!!";
        }

        return "SUCESSO AO SALVAR POSTGRES CHAINED!!!";
    }

    @GetMapping("/saveMySqlChained")
    public String saveInDatabaseMySqlChained() {
        try {
            this.generalService.saveInDatabaseMySqlChained();
        } catch (Exception ex) {
            return "ERRO AO SALVAR MYSQL CHAINED!!!";
        }

        return "SUCESSO AO SALVAR MYSQL CHAINED!!!";
    }

    @GetMapping("/saveMongoDbChained")
    public String saveInDatabaseMongoDbChained() {
        try {
            this.generalService.saveInDatabaseMongoDbChained();
        } catch (Exception ex) {
            return "ERRO AO SALVAR MONGODB CHAINED!!!";
        }

        return "SUCESSO AO SALVAR MONGODB CHAINED!!!";
    }

    @GetMapping("/savePostgres")
    public String saveInDatabasePostgres() {
        try {
            this.generalService.saveInDatabasePostgres();
        } catch (Exception ex) {
            return "ERRO AO SALVAR POSTGRES!!!";
        }

        return "SUCESSO AO SALVAR POSTGRES!!!";
    }

    @GetMapping("/saveMySql")
    public String saveInDatabaseMySql() {
        try {
            this.generalService.saveInDatabaseMySql();
        } catch (Exception ex) {
            return "ERRO AO SALVAR MYSQL!!!";
        }

        return "SUCESSO AO SALVAR MYSQL!!!";
    }

    @GetMapping("/saveMongoDb")
    public String saveInDatabaseMongoDb() {
        try {
            this.generalService.saveInDatabaseMongoDb();
        } catch (Exception ex) {
            return "ERRO AO SALVAR MONGODB!!!";
        }

        return "SUCESSO AO SALVAR MONGODB!!!";
    }

}
