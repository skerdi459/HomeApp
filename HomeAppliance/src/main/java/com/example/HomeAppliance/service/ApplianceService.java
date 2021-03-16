package com.example.HomeAppliance.service;

import com.example.HomeAppliance.dto.ApplianceDto;
import com.example.HomeAppliance.model.Appliance;
import com.example.HomeAppliance.model.Attributes;
import com.example.HomeAppliance.model.Location;
import com.example.HomeAppliance.model.Type;
import com.example.HomeAppliance.repository.ApplianceRepository;
import com.example.HomeAppliance.repository.AttributesRepository;
import com.example.HomeAppliance.repository.LocationRepository;
import com.example.HomeAppliance.repository.TypeRepositry;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplianceService {

    @Autowired
    private ApplianceRepository repository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private TypeRepositry typeRepositry;
    @Autowired
    AttributesRepository attributesRepository;




    public ResponseEntity<Appliance>  getOne(String Id){
        Optional<Appliance> appliance=repository.findById(Id);
        if (appliance.isPresent()){
            return new ResponseEntity<>(appliance.get(),HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }



    public void addLocation(Location location) {
          locationRepository.save(location);
    }

    public void addType(Type type) {
         typeRepositry.save(type);

    }
    public void addAttr(Attributes attributes) {
        attributesRepository.save(attributes);
}

    public Appliance addApliance(Appliance appliance) {
        return    repository.save(appliance);


    }





    public List<Appliance> convertApplianceDtoToAppliance(ApplianceDto appliance) {
        System.out.println("sadasdasdasdas"+appliance.getType());
        Appliance appliance1 = new Appliance();
        appliance1.setId(appliance.getId());
        appliance1.setName(appliance.getName());
        appliance1.setState(appliance.getState());

        Type type=new Type();
        System.out.println("sadasdasdasdas"+appliance.getType());
        type.setName(appliance.getType());

        List<String> listAppliances=new ArrayList<>();
        listAppliances.add(appliance1.getId());
        type.setAppliance(listAppliances);
        addType(type);
        appliance1.setType(type);

        Location location=new Location();
        location.setName(appliance.getLocation());
        List<String> list=new ArrayList<>();
        list.add(appliance1.getId());
        location.setAppliancesId(list);
        addLocation(location);
        appliance1.setLocation(location);

        List<Attributes> attributesList=new ArrayList<>();
        System.out.println(appliance.getAttributes());
        appliance.getAttributes().forEach(attributes -> {
            Attributes attr=new Attributes();
            attr.setName(attributes.getName());
            attr.setMin(attributes.getMin());
            attr.setMax(attributes.getMax());
            attr.setCurrent(attributes.getCurrent());
            attr.setAppliance(appliance1.getId());
            addAttr(attr);
            attributesList.add(attr);
        });



        appliance1.setAttributes(attributesList);
          addApliance(appliance1);
        return getAll();
    }




    public List<Appliance> changeStatus(String id) {
        System.out.println(id);
        Optional<Appliance> appliance=repository.findById(id);
        System.out.println(appliance);
        if(appliance.isPresent()){
            if(appliance.get().getState()==0){
                appliance.get().setState(1);
                repository.save(appliance.get());
            }
            else {
                appliance.get().setState(0);
                repository.save(appliance.get());
            }

        }
        return repository.findAll();
    }




    public List<Appliance> getAll() {
        List<Appliance> listApp=repository.findAll();
        return listApp;
    }



    public List<Appliance> increaseV(String id) {
        System.out.println("une jame id"+id);
        Optional<Attributes> attr=attributesRepository.findById(id);
        System.out.println("atttirnbutu"+attr);
        int newValue=attr.get().getCurrent()+1;
        if (attr.isPresent()){

            attr.get().setCurrent(newValue);
            System.out.println(attr.get().getCurrent());
            attributesRepository.save(attr.get());
        }
        System.out.println("une jamammme ktuuu"+attr.get().getAppliance());
        Appliance appliance=repository.findById(attr.get().getAppliance()).get();

        List<Attributes> list=appliance.getAttributes();

        list.forEach(attributes -> {
            if(attributes.getAttributeId().equals(id)){
                attributes.setCurrent(newValue);
            }

        });
        appliance.setAttributes(list);
        repository.save(appliance);
        return repository.findAll();
    }





    public List<Appliance> decreaseV(String id) {
        Optional<Attributes> attr=attributesRepository.findById(id);
        int newValue=attr.get().getCurrent()-1;
        if (attr.isPresent()){

            attr.get().setCurrent(newValue);
            System.out.println(attr.get().getCurrent());
            attributesRepository.save(attr.get());
        }
        Appliance appliance=repository.findById(attr.get().getAppliance()).get();
        List<Attributes> list=appliance.getAttributes();

        list.forEach(attributes -> {
            if(attributes.getAttributeId().equals(id)){
                attributes.setCurrent(newValue);
            }

        });
        appliance.setAttributes(list);
        repository.save(appliance);
        return repository.findAll();
    }




    public ResponseEntity<Attributes> findAttr(String id) {
        Optional<Attributes> attr=attributesRepository.findById(id);
        if(attr.isPresent()){
            return  new ResponseEntity<>(attr.get(),HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
