package com.api.praticandoexception.exceptions.exceptionHandler;

import lombok.Getter;

@Getter
public enum TipoDeProblema {

    RECURSO_NAO_ENCONTRADO("/entidade-nao_encontrada", "Entidade não encontrada");

    private String title;
    private String uri;

    TipoDeProblema(String path, String title){
        this.uri = "\"http://cadastrocerto.com.br"+ path ;
        this.title = title;
    }

}
