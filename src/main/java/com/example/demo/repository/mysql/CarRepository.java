package com.example.demo.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.mysql.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
