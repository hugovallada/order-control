package com.github.hugovallada.orderscontrol.repositories;

import com.github.hugovallada.orderscontrol.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
