package com.github.hugovallada.orderscontrol.config;

import java.time.Instant;
import java.util.Arrays;

import com.github.hugovallada.orderscontrol.entities.Order;
import com.github.hugovallada.orderscontrol.entities.enums.OrderStatus;
import com.github.hugovallada.orderscontrol.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.hugovallada.orderscontrol.entities.User;
import com.github.hugovallada.orderscontrol.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	private UserRepository userRepository;
	private OrderRepository orderRepository;
	
	@Autowired
	public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","9999999","12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","9999999","12345");
		
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T13:33:27Z"), OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2020-03-10T08:19:43Z"), OrderStatus.PAID,u1);

		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
