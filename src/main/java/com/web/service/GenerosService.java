package com.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.GenerosEntity;

@Service
public interface GenerosService {

    public List<GenerosEntity> listarGeneros();

    public GenerosEntity registrarGeneros(GenerosEntity generos );

    public GenerosEntity editarGeneros(GenerosEntity generos );

    public GenerosEntity buscarGeneros(int id);

    public void eliminarGeneros(int id);

}
