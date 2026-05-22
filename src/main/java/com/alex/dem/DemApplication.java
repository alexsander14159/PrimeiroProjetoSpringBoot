package com.alex.dem;

import Principal.principal;
import com.alex.dem.model.DadosSerie;
import com.alex.dem.model.DadosTemporada;
import com.alex.dem.service.ConsumoAPI;
import com.alex.dem.service.ConverteDados;
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
