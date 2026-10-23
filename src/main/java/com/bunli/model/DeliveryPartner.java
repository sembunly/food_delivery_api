package com.bunli.model;

import java.util.Date;

import com.bunli.enumeration.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_delivery_partner")
public class DeliveryPartner extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    private String password;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    private String email;
    private String address;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private boolean available;

}
