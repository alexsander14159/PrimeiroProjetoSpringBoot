package com.alex.dem;

import com.alex.dem.model.DadosSerie;
import com.alex.dem.model.DadosTemporada;
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
		System.out.println("Qual nome da Serie?");
		Scanner scanner = new Scanner(System.in);
		String Serie = scanner.next();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t="+Serie+"&apikey=5b9fd2c7");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
		System.out.println("Qual Temporada você quer?");
		int temporada = scanner.nextInt();
		json = consumoApi.obterDados("https://www.omdbapi.com/?t="+Serie+"&season="+temporada+"&apikey=5b9fd2c7");
		DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
		int totalEpisodios = dadosTemporada.episodios().size();
		System.out.println("--- Lista de Episódios ---");
		dadosTemporada.episodios().forEach(episodio -> System.out.println(episodio));
		dadosTemporada.episodios().forEach(System.out::println);
	}
}
