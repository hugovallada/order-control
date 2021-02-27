package com.github.hugovallada.orderscontrol.repositories;

import com.github.hugovallada.orderscontrol.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
