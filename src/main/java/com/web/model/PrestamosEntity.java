package com.web.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class PrestamosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="libro_id")
    private LibrosEntity libro;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private UsuariosEntity usuario;

    @Column
    private Date fecha_prestamo;

    @Column
    private Date fecha_devolucion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LibrosEntity getLibro() {
        return libro;
    }

    public void setLibro(LibrosEntity libro) {
        this.libro = libro;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    

    

}
