package com.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.UsuariosEntity;
import com.web.repository.UsuariosRepository;
import com.web.service.UsuariosService;

@Service
public class UsuariosServiceImplement implements UsuariosService {

    @Autowired
    private UsuariosRepository repo;

    @Override
    public List<UsuariosEntity> listarUsuarios() {
        return repo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public UsuariosEntity registrarUsuarios(UsuariosEntity usuarios) {
        return repo.save(usuarios);
    }

    @SuppressWarnings("null")
    @Override
    public UsuariosEntity editarUsuarios(UsuariosEntity usuarios) {
        return repo.save(usuarios);
    }

    @Override
    public UsuariosEntity buscarUsuarios(int id) {
        return repo.findById(id).get();
    }

    @Override
    public void eliminarUsuarios(int id) {
        repo.deleteById(id);
    }

}
