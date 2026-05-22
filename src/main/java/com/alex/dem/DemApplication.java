package com.alex.dem;

import com.alex.dem.Principal.principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal primeira = new principal();
		primeira.exibirMenu();
	}
}
