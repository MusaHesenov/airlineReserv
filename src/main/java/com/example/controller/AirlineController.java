package com.example.controller;

import com.example.entity.Airline;
import com.example.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/Airline")
public class AirlineController {

    AirlineService airlineService;
    @Autowired
    public AirlineController(AirlineService airlineService){
        this.airlineService=airlineService;
    }
    @PostMapping("/insert")
    public ResponseEntity<Airline> insert(Airline airline){
        return new ResponseEntity<Airline>(airlineService.save(airline), HttpStatus.ACCEPTED);
    }

    @GetMapping("/Airline/{id}")
    public ResponseEntity<Airline> getAirline(@PathVariable("id") Integer id){
        return new ResponseEntity<Airline>(airlineService.getAirlineById(id),HttpStatus.FOUND);
    }
    @GetMapping("/select")
    public ResponseEntity<String> select(@RequestParam("airline") String name){
        Airline airline = airlineService.getAirlineByName(name);
        return new ResponseEntity<String>(airline!=null?airline.getName():"not found",HttpStatus.OK);
    }
    @GetMapping("/selectall")
    public ResponseEntity<String> selectAll(){
        return new ResponseEntity<String>(airlineService.getAllAirline().toString(),HttpStatus.FOUND);
    }

}