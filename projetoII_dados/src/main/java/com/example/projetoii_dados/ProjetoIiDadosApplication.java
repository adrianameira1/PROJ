package com.example.projetoii_dados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.projetoii_dados",
		"com.example.core"
})
@EntityScan(basePackages = "com.example.core.models")
@EnableJpaRepositories(basePackages = "com.example.core.repositories")
public class ProjetoIiDadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoIiDadosApplication.class, args);
	}
}
