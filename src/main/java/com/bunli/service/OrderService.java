package com.bunli.service;

import com.bunli.dto.OrderRequest;
import com.bunli.dto.OrderResponse;
import com.bunli.dto.OrderStatusRequest;

public interface OrderService {

    OrderResponse create(OrderRequest orderRequest);

    OrderResponse update(OrderStatusRequest orderStatusRequest);
}
