package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.model.PrestamosEntity;
import com.web.service.LibrosService;
import com.web.service.PrestamosService;
import com.web.service.UsuariosService;

@Controller
public class PrestamosController {

    @Autowired
    private PrestamosService service;

    @Autowired
    private LibrosService librosService;

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/prestamos")
    public String listarPrestamos(Model model) {
        model.addAttribute("prestamos", this.service.findAllWithLibroAndUsuario());
        return "prestamos";
    }

    @GetMapping("/registrarprestamos")
    public String mostrarRegistro(Model model) {
        model.addAttribute("libros", this.librosService.listarLibros());
        model.addAttribute("usuarios", this.usuariosService.listarUsuarios());
        return "registrarprestamos";
    }

    @PostMapping("/crearprestamos")
    public String crearPrestamos(@ModelAttribute("PrestamosEntity") PrestamosEntity objentidad) {
        try {
            this.service.registrarPrestamos(objentidad);
            return "redirect:/prestamos";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/editarprestamos/{id}")
    public String editarPrestamos(@PathVariable int id, Model model) {
        model.addAttribute("libros", this.librosService.listarLibros());
        model.addAttribute("usuarios", this.usuariosService.listarUsuarios());
        model.addAttribute("objcontrolador", this.service.buscarPrestamos(id));
        return "editarprestamos";
    }

    @PostMapping("/editarprestamossave/{id}")
    public String editarprestamossave(@PathVariable int id, @ModelAttribute("entidad") PrestamosEntity objetoentidad,Model model) {

        // Crear una instancia de la clase entidad y service
        PrestamosEntity objeditarprestamos = this.service.buscarPrestamos(id);

        objeditarprestamos.setLibro(objetoentidad.getLibro());
        objeditarprestamos.setUsuario(objetoentidad.getUsuario());
        objeditarprestamos.setFecha_prestamo(objetoentidad.getFecha_prestamo());
        objeditarprestamos.setFecha_devolucion(objetoentidad.getFecha_devolucion());

        this.service.editarPrestamos(objeditarprestamos);

        return "redirect:/prestamos";
    }

    @GetMapping("/eliminarprestamos/{id}")
	public String eliminarprestamos(@PathVariable int id) {
	this.service.eliminarPrestamos(id);
	return "redirect:/prestamos";
    }



}
