package com.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.LibrosEntity;
import com.web.repository.LibrosRepository;
import com.web.service.LibrosService;

@Service
public class LibrosServiceImplement implements LibrosService {

    @Autowired
    private LibrosRepository repo;


    @Override
    public List<LibrosEntity> findAllWithAutorAndGenero() {
        return repo.findAllWithAutorAndGenero();
    }


    @Override
    public List<LibrosEntity> listarLibros() {
        return this.repo.findAll();
    }


    
    @SuppressWarnings("null")
    @Override
    public LibrosEntity registrarLibros(LibrosEntity libros) {
        return this.repo.save(libros);
    }


    @SuppressWarnings("null")
    @Override
    public LibrosEntity editarLibros(LibrosEntity libros) {
        return this.repo.save(libros);
    }


    @Override
    public LibrosEntity buscarLibros(int id) {
        return this.repo.findById(id).get();
    }


    @Override
    public void eliminarLibros(int id) {
        repo.deleteById(id);
    }


}
