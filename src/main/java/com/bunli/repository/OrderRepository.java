package com.bunli.repository;

import com.bunli.enumeration.OrderStatus;
import com.bunli.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findFirstByOrderId(String orderId);

    Optional<Order> findFirstByUserIdAndOrderStatusNot(Long userId, OrderStatus orderStatus);
}
