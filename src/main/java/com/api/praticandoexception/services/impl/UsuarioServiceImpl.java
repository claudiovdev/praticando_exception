package com.api.praticandoexception.services.impl;

import com.api.praticandoexception.enums.StatusDoUsuario;
import com.api.praticandoexception.models.Endereco;
import com.api.praticandoexception.models.UsuarioModel;
import com.api.praticandoexception.repositories.UsuarioRepository;
import com.api.praticandoexception.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UsuarioModel salvar(UsuarioModel usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuario.setEndereco(buscarEndereco(usuario.getEndereco().getCep()));
        usuario.setStatus(StatusDoUsuario.ATIVO);
        usuario = emailMinusculo(usuario);
        return repository.save(usuario);
    }

    @Override
    public List<UsuarioModel> listarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Endereco buscarEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep +"/json";
        return new RestTemplate().getForObject(url, Endereco.class);
    }

    public UsuarioModel emailMinusculo(UsuarioModel usuario){
        var email = usuario.getEmail();
        email = email.toLowerCase();
        usuario.setEmail(email);
        return usuario;
    }


}
