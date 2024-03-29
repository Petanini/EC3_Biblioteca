package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.GenerosEntity;

@Repository
public interface GenerosRepository extends JpaRepository<GenerosEntity, Integer>{

}
