package com.github.hugovallada.orderscontrol.repositories;

import com.github.hugovallada.orderscontrol.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
