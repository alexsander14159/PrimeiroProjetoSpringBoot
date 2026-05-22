package com.alex.dem.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCep(@JsonAlias("localidade") String local, @JsonAlias("uf") String uf, @JsonAlias("cep") String cep) {

}
