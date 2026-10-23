package com.bunli.service;

import com.bunli.dto.PaymentRequest;

public interface PaymentService {

    String pay(PaymentRequest paymentRequest);

    String inquiry(String orderId);
}
