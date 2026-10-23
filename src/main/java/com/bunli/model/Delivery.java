package com.bunli.model;

import java.util.Date;

import com.bunli.enumeration.DeliveryStatus;

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
@Table(name = "tbl_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIME)
    private Date pickupTime;

    @Temporal(TemporalType.TIME)
    private Date deliveryTime;

    private String pickupAddress;
    private String deliveryAddress;
    private double deliveryFee;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private Long deliveryPartnerId;
    private Long orderId;
}
