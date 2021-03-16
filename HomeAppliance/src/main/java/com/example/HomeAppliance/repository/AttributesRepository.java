package com.example.HomeAppliance.repository;


import com.example.HomeAppliance.model.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface AttributesRepository extends MongoRepository<Attributes, String> {

}
