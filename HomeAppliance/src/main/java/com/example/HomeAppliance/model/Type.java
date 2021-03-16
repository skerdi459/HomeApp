package com.example.HomeAppliance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class Type {
    @Id
    String typeId;
    String name;
    List<String> appliance=new ArrayList<>();;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAppliance() {
        return appliance;
    }

    public void setAppliance(List<String> appliance) {
        this.appliance = appliance;
    }
}
