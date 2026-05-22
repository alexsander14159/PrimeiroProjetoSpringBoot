package com.alex.dem.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") String ano,
                         @JsonAlias("totalSeasons") String Temporadas,@JsonAlias("imdbRating")String nota) {

}
