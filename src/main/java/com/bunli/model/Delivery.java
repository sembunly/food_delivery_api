
package com.bunli.model;

import com.bunli.enumeration.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_delivery")
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime pickupItem = LocalDateTime.now();
    private LocalDateTime deliveryTime = LocalDateTime.now();
    private String pickupAddress;
    private String deliveryAddress;
    private double deliveryFee;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private Long deliveryPartnerID;

    private Long orderID;
}
