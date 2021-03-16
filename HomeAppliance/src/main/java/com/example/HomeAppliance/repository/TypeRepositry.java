package com.example.HomeAppliance.repository;

import com.example.HomeAppliance.model.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypeRepositry extends MongoRepository<Type,String> {

}
