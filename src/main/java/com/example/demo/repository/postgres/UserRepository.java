package com.example.demo.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.postgres.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
