package com.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="libros")
public class LibrosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private AutoresEntity autor;

    @ManyToOne
    @JoinColumn(name="genero_id")
    private GenerosEntity genero;

    @Column
    private String editorial;

    @Column
    private int anio_publicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutoresEntity getAutor() {
        return autor;
    }
    
    public void setAutor(AutoresEntity autor) {
        this.autor = autor;
    }

    public GenerosEntity getGenero() {
        return genero;
    }

    public void setGenero(GenerosEntity genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }
}
