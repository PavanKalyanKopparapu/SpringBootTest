package com.example.SpringBootTest.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    Integer carId;
    String name;
    String make;
    String model;
    Integer makeYear;
    Integer comfortLevel;
}
