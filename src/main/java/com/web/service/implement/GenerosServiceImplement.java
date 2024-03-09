package com.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.GenerosEntity;
import com.web.repository.GenerosRepository;
import com.web.service.GenerosService;

@Service
public class GenerosServiceImplement implements GenerosService {

    @Autowired
    private GenerosRepository repo;

    @Override
    public List<GenerosEntity> listarGeneros() {
        return repo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public GenerosEntity registrarGeneros(GenerosEntity generos) {
        return this.repo.save(generos);
    }

    @SuppressWarnings("null")
    @Override
    public GenerosEntity editarGeneros(GenerosEntity generos) {
        return this.repo.save(generos);
    }

    @Override
    public GenerosEntity buscarGeneros(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void eliminarGeneros(int id) {

        this.repo.deleteById(id);
    }

}
