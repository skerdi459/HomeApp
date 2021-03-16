package com.example.HomeAppliance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class Location {
    @Id
    String locationId;
    String name;
    List<String> appliancesId=new ArrayList<>();

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAppliancesId() {
        return appliancesId;
    }

    public void setAppliancesId(List<String> appliancesId) {
        this.appliancesId = appliancesId;
    }
}
