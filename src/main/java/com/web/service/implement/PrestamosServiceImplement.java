package com.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.PrestamosEntity;
import com.web.repository.PrestamosRepository;
import com.web.service.PrestamosService;

@Service
public class PrestamosServiceImplement implements PrestamosService{

    @Autowired
    private PrestamosRepository repo;

    @Override
    public List<PrestamosEntity> findAllWithLibroAndUsuario() {

        return repo.findAllWithLibroAndUsuario();
    }

    @Override
    public List<PrestamosEntity> listarPrestamos() {

        return this.repo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public PrestamosEntity registrarPrestamos(PrestamosEntity prestamos) {
        
        return this.repo.save(prestamos);
    }

    @SuppressWarnings("null")
    @Override
    public PrestamosEntity editarPrestamos(PrestamosEntity prestamos) {
        return this.repo.save(prestamos);
    }

    @Override
    public PrestamosEntity buscarPrestamos(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void eliminarPrestamos(int id) {
        repo.deleteById(id);
    }

    

}
