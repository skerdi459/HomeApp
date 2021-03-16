package com.example.HomeAppliance.controller;

import com.example.HomeAppliance.dto.ApplianceDto;
import com.example.HomeAppliance.model.Appliance;
import com.example.HomeAppliance.model.Attributes;
import com.example.HomeAppliance.model.Location;
import com.example.HomeAppliance.model.Type;
import com.example.HomeAppliance.service.ApplianceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@AllArgsConstructor
public class Controller {
    @Autowired
   private ApplianceService service;
    private final Logger logger=LoggerFactory.getLogger(getClass());

    @SubscribeMapping("/posts/all")
    public List<Appliance> getAll(){
        return service.getAll();
    }

    @SubscribeMapping("/getOne/{id}")
    public ResponseEntity<Appliance> getOne(@DestinationVariable ("id")String id){
        return service.getOne(id);
    }

    @MessageMapping("/add/appliaces/")
    @SendTo("/topic/posts/all")
    public List<Appliance> addApliance(@RequestBody ApplianceDto appliance){
        return service.convertApplianceDtoToAppliance(appliance);
    }

    @MessageMapping("/changeStatus/{id}/on")
    @SendTo("/topic/posts/all")
    public List<Appliance>changeStatus(@DestinationVariable("id") String id){
        logger.info("info mvi "+id);
         List<Appliance> list=service.changeStatus(id);
        return list ;
    }



    @MessageMapping("/increase/{id}/Attr/")
    @SendTo("/topic/posts/all")
    public List<Appliance> increaseValue(@DestinationVariable("id")String id){
        return  service.increaseV(id);
    }

    @MessageMapping("/decreaseAttr/{id}")
    @SendTo("/topic/posts/all")
    public List<Appliance> decreaseValue(@DestinationVariable("id")String id){
        return  service.decreaseV(id);
    }

    @SubscribeMapping("/getattribute/{id}")
    public ResponseEntity<Attributes> findAttribute(@DestinationVariable ("id")String id ){
        return service.findAttr(id);
    }






}
