package com.crud.demo.controlador;

import com.crud.demo.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.demo.servicio.EventoServicio;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoControlador {

    @Autowired
    private EventoServicio servicio;

    @GetMapping({"/eventos", "/"})
    public String listarEventos(Model modelo){
        modelo.addAttribute("eventos",servicio.listarEventos());
        return "eventos";
    }

    @GetMapping("/eventos/nuevo")
    public String mostrarFormularioDeRegistrtarEventos(Model modelo) {
        Evento evento = new Evento();
        modelo.addAttribute("evento", evento);
        return "crear_evento";
    }

    @PostMapping("/eventos")
    public  String  guardarEvento(@ModelAttribute("evento")Evento evento){
        servicio.guardarEvento(evento);
        return "redirect:/eventos";
    }
}
