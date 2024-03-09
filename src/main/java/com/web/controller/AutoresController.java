package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.model.AutoresEntity;
import com.web.service.AutoresService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutoresController {

    @Autowired
    private AutoresService service;

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        model.addAttribute("autores", this.service.listarAutores());
        return "autores";
    }

    @GetMapping("/registrarautores")
    public String mostrarCrearAutor(Model model) {
        return "registrarautores";
    }

    @GetMapping("/editarautores/{id}")
    public String editarautores(@PathVariable int id, Model model) {
        model.addAttribute("objcontrolador", this.service.buscarAutores(id));
        return "editarautores";
    }

    @PostMapping("/editarautoressave/{id}")
    public String editarautoressave(@PathVariable int id, @ModelAttribute("entidad") AutoresEntity objetoentidad,
            Model model) {

        // Crear una instancia de la clase entidad y service
        AutoresEntity objeditarautores = this.service.buscarAutores(id);

        objeditarautores.setNombre(objetoentidad.getNombre());
        objeditarautores.setNacionalidad(objetoentidad.getNacionalidad());
        

        this.service.editarAutores(objeditarautores);

        return "redirect:/autores";
    }

    @PostMapping("/crearautores")
    public String crearautores(@ModelAttribute("AutoresEntity") AutoresEntity objentidad) {
        try {
            this.service.registrarAutores(objentidad);
            return "redirect:/autores";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @GetMapping("/eliminarautores/{id}")
	public String eliminarautores(@PathVariable int id) {
	this.service.eliminarAutores(id);
	return "redirect:/autores";
    }
}
