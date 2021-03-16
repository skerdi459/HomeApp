package com.example.HomeAppliance.repository;

import com.example.HomeAppliance.model.Appliance;
import com.example.HomeAppliance.model.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ApplianceRepository extends MongoRepository<Appliance,String> {







}
