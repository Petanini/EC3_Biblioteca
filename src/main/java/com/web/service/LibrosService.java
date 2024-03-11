package com.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.LibrosEntity;

@Service
public interface LibrosService {

    public List<LibrosEntity> findAllWithAutorAndGenero();

    public List<LibrosEntity> listarLibros();

    public LibrosEntity registrarLibros(LibrosEntity libros );

    public LibrosEntity editarLibros(LibrosEntity libros );

    public LibrosEntity buscarLibros(int id);

    public void eliminarLibros(int id);
}
