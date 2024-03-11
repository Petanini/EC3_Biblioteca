package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.model.UsuariosEntity;
import com.web.service.UsuariosService;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", this.service.listarUsuarios());
        return "usuarios";
    }

    @GetMapping("/registrarusuarios")
    public String mostrarCrearUsuario(Model model) {
        return "registrarusuarios";
    }

    @GetMapping("/editarusuarios/{id}")
    public String editarusuarios(@PathVariable int id, Model model) {
        model.addAttribute("objcontrolador", this.service.buscarUsuarios(id));
        return "editarusuarios";
    }

    @PostMapping("/editarusuariossave/{id}")
    public String editarusuariossave(@PathVariable int id, @ModelAttribute("entidad") UsuariosEntity objetoentidad,
            Model model) {

        // Crear una instancia de la clase entidad y service
        UsuariosEntity objeditarusuarios = this.service.buscarUsuarios(id);

        objeditarusuarios.setNombre(objetoentidad.getNombre());
        objeditarusuarios.setCorreo(objetoentidad.getCorreo());
        objeditarusuarios.setTelefono(objetoentidad.getTelefono());
        

        this.service.editarUsuarios(objeditarusuarios);

        return "redirect:/usuarios";
    }

    @PostMapping("/crearusuarios")
    public String crearusuarios(@ModelAttribute("UsuariosEntity") UsuariosEntity objentidad) {
        try {
            this.service.registrarUsuarios(objentidad);
            return "redirect:/usuarios";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @GetMapping("/eliminarusuarios/{id}")
	public String eliminarusuarios(@PathVariable int id) {
	this.service.eliminarUsuarios(id);
	return "redirect:/usuarios";
    }

}
