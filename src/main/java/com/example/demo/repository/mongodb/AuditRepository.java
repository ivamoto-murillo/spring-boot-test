package com.example.demo.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.mongodb.Audit;

@Repository
public interface AuditRepository extends MongoRepository<Audit, String> {

}
