package com.bunli.service;

import com.bunli.dto.DeliveryPartnerRequest;
import com.bunli.dto.DeliveryPartnerResponse;

import java.util.List;

public interface DeliveryPartnerService {

    DeliveryPartnerResponse create(DeliveryPartnerRequest deliveryPartnerRequest);

    DeliveryPartnerResponse update(Long id, DeliveryPartnerRequest deliveryPartnerRequest);

    void delete(Long id);

    DeliveryPartnerResponse getById(Long id);

    List<DeliveryPartnerResponse> getAll();
}
