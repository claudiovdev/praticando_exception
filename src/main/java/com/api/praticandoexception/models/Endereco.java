package com.api.praticandoexception.models;

import lombok.Data;

@Data
public class Endereco {

    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;
}
