package com.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.UsuariosEntity;



@Service
public interface UsuariosService {

    public List<UsuariosEntity> listarUsuarios();

    public UsuariosEntity registrarUsuarios(UsuariosEntity usuarios );

    public UsuariosEntity editarUsuarios(UsuariosEntity usuarios );

    public UsuariosEntity buscarUsuarios(int id);

    public void eliminarUsuarios(int id);

}
