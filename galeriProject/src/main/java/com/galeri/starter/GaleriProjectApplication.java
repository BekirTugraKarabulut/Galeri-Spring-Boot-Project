package com.galeri.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.galeri"})
@EntityScan(basePackages = {"com.galeri"})
@EnableJpaRepositories(basePackages = {"com.galeri"})
@SpringBootApplication
public class GaleriProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaleriProjectApplication.class, args);
	}

}
