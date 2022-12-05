package com.api.praticandoexception.models;

import lombok.Data;


import javax.persistence.*;

@Data
@Table(name = "TB_CARGOS")
@Entity
public class Cargo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 100)
    private String descricao;

}
