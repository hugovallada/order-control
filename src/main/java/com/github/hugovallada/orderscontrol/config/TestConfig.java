package com.github.hugovallada.orderscontrol.config;

import com.github.hugovallada.orderscontrol.entities.*;
import com.github.hugovallada.orderscontrol.entities.enums.OrderStatus;
import com.github.hugovallada.orderscontrol.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum", 20.70, "url");
        Product p2 = new Product(null, "Smart TV", "Lorem ipsum", 3000.00, "url");
        Product p3 = new Product(null, "MacBook Pro", "Lorem ipsum", 18650.90, "url");
        Product p4 = new Product(null, "Lenovo ThinkPad", "Lorem ipsum", 6070.00, "url");
        Product p5 = new Product(null, "Rails for dummies", "Lorem ipsum", 100.70, "url");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // tb_category_products

        p1.getCategories().add(c2);
        p2.getCategories().addAll(Arrays.asList(c1, c3));
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9999999", "12345");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9999999", "12345");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T13:33:27Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2020-03-10T08:19:43Z"), OrderStatus.PAID, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // OrderItem

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2020-03-10T10:19:37Z"), o3);
        o1.setPayment(pay1);

        orderRepository.save(o1);

    }


}
