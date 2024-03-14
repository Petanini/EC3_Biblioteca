package com.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.PrestamosEntity;



@Service
public interface PrestamosService {

    public List<PrestamosEntity> findAllWithLibroAndUsuario();

    public List<PrestamosEntity> listarPrestamos();

    public PrestamosEntity registrarPrestamos(PrestamosEntity prestamos );

    public PrestamosEntity editarPrestamos(PrestamosEntity prestamos );

    public PrestamosEntity buscarPrestamos(int id);

    public void eliminarPrestamos(int id);

}
