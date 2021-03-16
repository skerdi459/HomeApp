package com.example.HomeAppliance.repository;

import com.example.HomeAppliance.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location,String> {
}
