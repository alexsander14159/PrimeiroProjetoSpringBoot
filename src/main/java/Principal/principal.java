package Principal;

import com.alex.dem.model.DadosEpisodio;
import com.alex.dem.model.DadosSerie;
import com.alex.dem.model.DadosTemporada;
import com.alex.dem.service.ConsumoAPI;
import com.alex.dem.service.ConverteDados;

import java.util.Scanner;

public class principal {
    private final String ENDEREÇO = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=5b9fd2c7";
    ConsumoAPI consumoApi = new ConsumoAPI();
    Scanner scanner = new Scanner(System.in);
    public void exibirMenu(){
        System.out.println("--MENU--\nQual o nome da Serie?");
        var nome = scanner.nextLine();
        var json = consumoApi.obterDados(ENDEREÇO+nome.replace(" ","+")+APIKEY);
        var conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
        System.out.println(dados);
        System.out.println("Qual temporada você quer?");
        int temporada = scanner.nextInt();
        json = consumoApi.obterDados(ENDEREÇO + nome.replace(" ", "+") + "&season=" + temporada + APIKEY);
        conversor = new ConverteDados();
        DadosTemporada dadosTemporada =  conversor.obterDados(json,DadosTemporada.class);
        System.out.println("--- Lista de Episódios ---");
        dadosTemporada.episodios().forEach(episodio -> System.out.println(episodio));
        dadosTemporada.episodios().forEach(System.out::println);



    }
}
