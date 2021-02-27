package com.github.hugovallada.orderscontrol.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import com.github.hugovallada.orderscontrol.entities.Category;
import com.github.hugovallada.orderscontrol.entities.Order;
import com.github.hugovallada.orderscontrol.entities.Product;
import com.github.hugovallada.orderscontrol.entities.enums.OrderStatus;
import com.github.hugovallada.orderscontrol.repositories.CategoryRepository;
import com.github.hugovallada.orderscontrol.repositories.OrderRepository;
import com.github.hugovallada.orderscontrol.repositories.ProductRepository;
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
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(c1, c2,c3));

		Product p1 = new Product(null,"The Lord of the Rings", "Lorem ipsum", 20.70, "url");
		Product p2 = new Product(null,"Smart TV", "Lorem ipsum", 3000.00, "url");
		Product p3 = new Product(null,"MacBook Pro", "Lorem ipsum", 18650.90, "url");
		Product p4 = new Product(null,"Lenovo ThinkPad", "Lorem ipsum", 6070.00, "url");
		Product p5 = new Product(null,"Rails for dummies", "Lorem ipsum", 100.70, "url");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com","9999999","12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","9999999","12345");
		
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T13:33:27Z"), OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2020-03-10T08:19:43Z"), OrderStatus.PAID,u1);

		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

	}
	
	
}
