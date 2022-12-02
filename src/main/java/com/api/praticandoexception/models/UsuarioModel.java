package com.api.praticandoexception.models;

import com.api.praticandoexception.enums.StatusDoUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "TB_USUARIOS")
public class UsuarioModel {

    @EqualsAndHashCode.Exclude
    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String numeroTelefone;

    @Embedded
    Endereco endereco;

    @Enumerated(EnumType.STRING)
    private StatusDoUsuario status;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataDeCadastro;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataDeAtualizacao;

}
