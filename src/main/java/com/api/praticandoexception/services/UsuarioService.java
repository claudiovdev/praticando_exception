package com.api.praticandoexception.services;

import com.api.praticandoexception.models.UsuarioModel;

import java.util.List;

public interface UsuarioService {
    UsuarioModel salvar(UsuarioModel usuario);

    List<UsuarioModel> listarUsuarios();
}
