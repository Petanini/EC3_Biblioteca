package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.model.PrestamosEntity;

@Repository
public interface PrestamosRepository extends JpaRepository<PrestamosEntity, Integer>{

    @Query("SELECT p FROM PrestamosEntity p JOIN FETCH p.libro l JOIN FETCH p.usuario u")
    List<PrestamosEntity> findAllWithLibroAndUsuario();

}
