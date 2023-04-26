package com.example.SpringBootTest.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ride implements Serializable {

    @Id
    Integer rideId;

    @ManyToOne
    @JoinColumn(name = "member_car_id")
    MemberCar memberCar;

    LocalDate createdOn;

    LocalDate travelStartTime;

    @ManyToOne
    @JoinColumn(name = "source_city_id")
    City sourceCity;

    @ManyToOne
    @JoinColumn(name = "destination_city_id")
    City destinationCity;

    Integer seatsOffered;

    Integer contributionPerHead;
}
