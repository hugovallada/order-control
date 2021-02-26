package com.github.hugovallada.orderscontrol.config;

import java.util.Arrays;

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
	
	@Autowired
	public TestConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","9999999","12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","9999999","12345");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
