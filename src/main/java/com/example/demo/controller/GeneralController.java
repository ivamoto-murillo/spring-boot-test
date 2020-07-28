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

}
