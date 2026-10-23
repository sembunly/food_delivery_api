package com.bunli.repository;

import com.bunli.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {

    List<DeliveryPartner> findAllByAvailable(boolean available);
}
