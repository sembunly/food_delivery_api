package com.bunli.model;

import com.bunli.enumeration.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_delivery_partner")
public class DeliveryPartner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(name = "username", unique = true, nullable = false)
    private String username;
    private String password;
    private String gender;
    private String dateOfBirth;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    private String email;
    private String address;
    private VehicleType vehicleType;
    private boolean available;

}
