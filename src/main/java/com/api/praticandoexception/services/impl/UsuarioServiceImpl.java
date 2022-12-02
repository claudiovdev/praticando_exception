package com.api.praticandoexception.services.impl;

import com.api.praticandoexception.enums.StatusDoUsuario;
import com.api.praticandoexception.models.UsuarioModel;
import com.api.praticandoexception.repositories.UsuarioRepository;
import com.api.praticandoexception.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UsuarioModel salvar(UsuarioModel usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuario.setStatus(StatusDoUsuario.ATIVO);
        usuario = emailMinusculo(usuario);
        return repository.save(usuario);
    }

    public UsuarioModel emailMinusculo(UsuarioModel usuario){
        var email = usuario.getEmail();
        email = email.toLowerCase();
        usuario.setEmail(email);
        return usuario;
    }
}
