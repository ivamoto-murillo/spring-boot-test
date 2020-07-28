package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.mysql.Car;
import com.example.demo.model.postgres.User;
import com.example.demo.repository.mysql.CarRepository;
import com.example.demo.repository.postgres.UserRepository;

@Service
public class GeneralService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(value = "chainedTransactionManager")
    public void saveInDatabases() {
        this.userRepository.save(new User("Murillo"));
        this.carRepository.save(new Car("Palio"));
    }

}
