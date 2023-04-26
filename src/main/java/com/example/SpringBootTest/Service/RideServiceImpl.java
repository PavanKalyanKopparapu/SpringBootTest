package com.example.SpringBootTest.Service;

import com.example.SpringBootTest.Entity.Ride;
import com.example.SpringBootTest.Repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@CacheConfig(cacheNames = "ride")
@Service
public class RideServiceImpl implements RideService{
    @Autowired
    private RideRepository rideRepository;

    @Override
    public List<Ride> addRides(Ride[] rides) {
        return rideRepository.saveAll(Arrays.asList(rides));
    }

    @CacheEvict(allEntries = true)
    @Cacheable("ride")
    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @Cacheable(key = "#rideId")
    @Override
    public Ride getRideById(Integer rideId) {
        return rideRepository.findById(rideId).get();
    }

    @CachePut(key = "#rideId")
    @Override
    public String updateRide(Integer rideId, Ride ride) {
        Ride ride1 = rideRepository.findById(rideId).get();
        if(ride.getMemberCar()!=null)
            ride1.setMemberCar(ride.getMemberCar());
        if(ride.getCreatedOn()!=null)
            ride1.setCreatedOn(ride.getCreatedOn());
        if(ride.getTravelStartTime()!=null)
            ride1.setTravelStartTime(ride.getTravelStartTime());
        if(ride.getSourceCity()!=null)
            ride1.setSourceCity(ride.getSourceCity());
        if(ride.getDestinationCity()!=null)
            ride1.setDestinationCity(ride.getDestinationCity());
        if(ride.getSeatsOffered()!=null)
            ride1.setSeatsOffered(ride.getSeatsOffered());
        if(ride.getContributionPerHead()!=null)
            ride1.setContributionPerHead(ride.getContributionPerHead());
        rideRepository.save(ride1);
        return "Updated Successfully";
    }

    @CacheEvict(key = "#rideId")
    @Override
    public String deleteRide(Integer rideId) {
        rideRepository.deleteById(rideId);
        return "Record Successfully deleted";
    }

    @CacheEvict(allEntries = true)
    @Override
    public String deleteAllRides() {
        rideRepository.deleteAll();
        return "All records deleted successfully";
    }
}
