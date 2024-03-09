package com.web.service.implement;

import java.util.List;

import com.web.model.AutoresEntity;
import com.web.repository.AutoresRepository;
import com.web.service.AutoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoresServiceImplement implements AutoresService {

    @Autowired
    private AutoresRepository repo;

    @Override
    public List<AutoresEntity> listarAutores() {
        
        return repo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public AutoresEntity registrarAutores(AutoresEntity autores) {
        return this.repo.save(autores);
    }

    @SuppressWarnings("null")
    @Override
    public AutoresEntity editarAutores(AutoresEntity autores) {
        return this.repo.save(autores);
    }

    @Override
    public AutoresEntity buscarAutores(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void eliminarAutores(int id) {
        this.repo.deleteById(id);
    }

}
