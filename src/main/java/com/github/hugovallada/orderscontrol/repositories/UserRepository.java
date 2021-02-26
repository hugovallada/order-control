package com.github.hugovallada.orderscontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hugovallada.orderscontrol.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
