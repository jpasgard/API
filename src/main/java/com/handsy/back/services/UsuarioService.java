package com.handsy.back.services;

import com.handsy.back.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
}
