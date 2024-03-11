package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.web.model.GenerosEntity;
import com.web.model.LibrosEntity;
import com.web.service.AutoresService;
import com.web.service.GenerosService;
import com.web.service.LibrosService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibrosController {

    @Autowired
    private LibrosService service;

    @Autowired
    private AutoresService autoresService;

    @Autowired
    private GenerosService generosService;

    @GetMapping("/libros")
    public String listarlibros(Model model) {
        model.addAttribute("libros", this.service.findAllWithAutorAndGenero());
        return "libros";
    }

    @GetMapping("/registrarlibros")
    public String mostrarRegistro(Model model) {
        model.addAttribute("autores", this.autoresService.listarAutores());
        model.addAttribute("generos", this.generosService.listarGeneros());
        //model.addAttribute("LibrosEntity", new LibrosEntity());
        return "registrarlibros";
    }

    @PostMapping("/crearlibros")
    public String crearLibros(@ModelAttribute("LibrosEntity") LibrosEntity objentidad) {
        try {
            this.service.registrarLibros(objentidad);
            return "redirect:/libros";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @GetMapping("/editarlibros/{id}")
    public String editarlibros(@PathVariable int id, Model model) {
        model.addAttribute("autores", this.autoresService.listarAutores());
        model.addAttribute("generos", this.generosService.listarGeneros());
        model.addAttribute("objcontrolador", this.service.buscarLibros(id));
        return "editarlibros";
    }

    @PostMapping("/editarlibrossave/{id}")
    public String editarlibrossave(@PathVariable int id, @ModelAttribute("entidad") LibrosEntity objetoentidad,Model model) {

        // Crear una instancia de la clase entidad y service
        LibrosEntity objeditarlibros = this.service.buscarLibros(id);

        objeditarlibros.setTitulo(objetoentidad.getTitulo());
        objeditarlibros.setAutor(objetoentidad.getAutor());
        objeditarlibros.setGenero(objetoentidad.getGenero());
        objeditarlibros.setEditorial(objetoentidad.getEditorial());
        objeditarlibros.setAnio_publicacion(objetoentidad.getAnio_publicacion());

        this.service.editarLibros(objeditarlibros);

        return "redirect:/libros";
    }

    @GetMapping("/eliminarlibros/{id}")
	public String eliminarlibros(@PathVariable int id) {
	this.service.eliminarLibros(id);
	return "redirect:/libros";
    }

}
