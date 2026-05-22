package com.alex.dem.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
