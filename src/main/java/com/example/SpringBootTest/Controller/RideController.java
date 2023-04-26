package com.example.SpringBootTest.Controller;

import com.example.SpringBootTest.Entity.Ride;
import com.example.SpringBootTest.Repository.RideRepository;
import com.example.SpringBootTest.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideController {

    @Autowired
    RideService rideService;

    @PostMapping("/addRides")
    public ResponseEntity<List<Ride>> addRides(@RequestBody Ride[] rides){
        return new ResponseEntity<>(rideService.addRides(rides), HttpStatus.CREATED);
    }

    @GetMapping("/getAllRides")
    public ResponseEntity<List<Ride>> getAllRides(){
        return new ResponseEntity<>(rideService.getAllRides(),HttpStatus.OK);
    }

    @GetMapping("/getRideById")
    public ResponseEntity<Ride> getRideById(@RequestParam(value = "rideId") Integer rideId){
        return new ResponseEntity<>(rideService.getRideById(rideId),HttpStatus.OK);
    }

    @PutMapping("/updateRide")
    public ResponseEntity<String> updateRide(@RequestParam(value = "rideId") Integer rideId, @RequestBody Ride ride){
        return new ResponseEntity<>(rideService.updateRide(rideId,ride),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteRide")
    public ResponseEntity<String> deleteRide(@RequestParam(value = "rideId") Integer rideId){
        return new ResponseEntity<>(rideService.deleteRide(rideId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAllRides")
    public ResponseEntity<String> deleteAllRides(){
        return new ResponseEntity<>(rideService.deleteAllRides(),HttpStatus.ACCEPTED);
    }
}
