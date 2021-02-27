package com.github.hugovallada.orderscontrol.repositories;

import com.github.hugovallada.orderscontrol.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
