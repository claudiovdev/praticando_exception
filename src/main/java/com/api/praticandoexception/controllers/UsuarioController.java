package com.api.praticandoexception.controllers;

import com.api.praticandoexception.models.UsuarioModel;
import com.api.praticandoexception.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return service.salvar(usuario);
    }
}
