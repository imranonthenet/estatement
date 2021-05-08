package com.bsf.estatement;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.*;
import com.bsf.estatement.models.User;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EstatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstatementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			
			User user = new User(
					3,"Neil","security",true,"ROLE_USER"
					);
					
			userRepository.save(user);
			
			userRepository.findUserByPassword("pass").ifPresent(userObj -> {
				System.out.println("name: " + userObj.getUsername());
			});
			
			List<User> users = userRepository.findByPasswordEqualsAndRolesEquals("security", "ROLE_USER");
			users.forEach(userObj -> {
				System.out.println("name of password and role: " + userObj.getUsername());
			});
		};
	}
}
