package com.web.service;

import java.util.List;

import com.web.model.AutoresEntity;

import org.springframework.stereotype.Service;

@Service
public interface AutoresService {

    public List<AutoresEntity> listarAutores();

    public AutoresEntity registrarAutores(AutoresEntity autores );

    public AutoresEntity editarAutores(AutoresEntity autores );

    public AutoresEntity buscarAutores(int id);

    public void eliminarAutores(int id);

}
