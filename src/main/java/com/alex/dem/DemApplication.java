package com.alex.dem;

import com.alex.dem.model.DadosCep;
import com.alex.dem.service.ConsumoAPI;
import com.alex.dem.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		System.out.println("Qual o CEP?");
		Scanner scanner = new Scanner(System.in);
		String cep = scanner.next();
		var json = consumoApi.obterDados("https://viacep.com.br/ws/"+cep+"/json/");
		ConverteDados conversor = new ConverteDados();
		DadosCep dados = conversor.obterDados(json,DadosCep.class);
		System.out.println(dados);
	}
}
