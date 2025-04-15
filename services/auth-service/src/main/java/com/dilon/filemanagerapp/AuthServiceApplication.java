package com.dilon.filemanagerapp;

import com.dilon.filemanagerapp.model.Roles;
import com.dilon.filemanagerapp.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			// This is where you can add any startup logic if needed
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(
						Roles.builder().name("USER").description("Default rol for all users").build()
				);
			}
		};
	}

}
