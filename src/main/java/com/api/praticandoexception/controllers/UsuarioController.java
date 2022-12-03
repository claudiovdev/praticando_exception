package com.api.praticandoexception.controllers;

import com.api.praticandoexception.exceptions.EntidadeNaoEncontradaException;
import com.api.praticandoexception.exceptions.exceptionHandler.Problema;
import com.api.praticandoexception.models.UsuarioModel;
import com.api.praticandoexception.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return service.salvar(usuario);
    }

    @GetMapping
    public List<UsuarioModel> buscarUsuarios(){
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioModel buscaUsuarioPorId(@PathVariable("id") String id){
        return service.buscarUsuario(id);

    }

}

