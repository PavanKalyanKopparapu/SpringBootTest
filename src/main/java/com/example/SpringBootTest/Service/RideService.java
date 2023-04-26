package com.example.SpringBootTest.Service;

import com.example.SpringBootTest.Entity.Ride;

import java.util.List;

public interface RideService {

    List<Ride> addRides(Ride[] rides);

    List<Ride> getAllRides();

    Ride getRideById(Integer rideId);

    String updateRide(Integer rideId,Ride ride);

    String deleteRide(Integer rideId);

    String deleteAllRides();

}
