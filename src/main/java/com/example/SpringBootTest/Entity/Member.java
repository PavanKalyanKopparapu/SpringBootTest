package com.example.SpringBootTest.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    Integer memberId;
    String firstName;
    String lastName;
    String email;
    String contactNumber;
    String drivingLicenseNumber;
    LocalDate drivingLicenseValidFrom;
}
