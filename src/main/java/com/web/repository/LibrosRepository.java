package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.model.LibrosEntity;

@Repository
public interface LibrosRepository extends JpaRepository<LibrosEntity, Integer> {

    // Consulta con Query

    @Query("SELECT l FROM LibrosEntity l JOIN FETCH l.autor a JOIN FETCH l.genero g")
    List<LibrosEntity> findAllWithAutorAndGenero();

}
