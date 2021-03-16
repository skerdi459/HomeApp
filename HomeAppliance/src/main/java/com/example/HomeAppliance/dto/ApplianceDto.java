package com.example.HomeAppliance.dto;

import com.example.HomeAppliance.model.Attributes;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDto {
    @Id
    private String id;
    private String name;
    private int state;
    private String type;
    private String location;
    private List<Attributes> attributes=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }
}
