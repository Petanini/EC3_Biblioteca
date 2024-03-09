package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.model.GenerosEntity;
import com.web.service.GenerosService;

@Controller
public class GeneroController {

    @Autowired
    private GenerosService service;

    @GetMapping("/generos")
    public String listarGeneros(Model model) {
        model.addAttribute("generos", this.service.listarGeneros());
        return "generos";
    }

    @GetMapping("/registrargeneros")
    public String mostrarCrearAutor(Model model) {
        return "registrargeneros";
    }

    @GetMapping("/editargeneros/{id}")
    public String editargeneros(@PathVariable int id, Model model) {
        model.addAttribute("objcontrolador", this.service.buscarGeneros(id));
        return "editargeneros";
    }

    @PostMapping("/editargenerossave/{id}")
    public String editargenerossave(@PathVariable int id, @ModelAttribute("entidad") GenerosEntity objetoentidad,
            Model model) {

        // Crear una instancia de la clase entidad y service
        GenerosEntity objeditargeneros = this.service.buscarGeneros(id);

        objeditargeneros.setNombre(objetoentidad.getNombre());

        this.service.editarGeneros(objeditargeneros);

        return "redirect:/generos";
    }

    @PostMapping("/creargeneros")
    public String creargeneros(@ModelAttribute("GenerosEntity") GenerosEntity objentidad) {
        try {
            this.service.registrarGeneros(objentidad);
            return "redirect:/generos";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @GetMapping("/eliminargeneros/{id}")
	public String eliminargeneros(@PathVariable int id) {
	this.service.eliminarGeneros(id);
	return "redirect:/generos";
    }

}
