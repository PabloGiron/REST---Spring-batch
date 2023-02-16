package com.example.rest;

import com.example.rest.entities.User;
import com.example.rest.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ConfigClass configClass = new ConfigClass();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
		configClass.corePoolSize++;
		System.out.println(configClass.corePoolSize);

		for (int i = 0; i < 300000; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.pokemon().name());
			user.setProfile(null);
			userRepository.save(user);
		}
	}
}
