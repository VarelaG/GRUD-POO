package com.crud.demo.controlador;

import com.crud.demo.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.demo.servicio.EventoServicio;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoControlador {

    @Autowired
    private EventoServicio servicio;

    @GetMapping("/eventos")
    public String listarEventos(Model modelo) {
        modelo.addAttribute("eventos", servicio.listarEventos());
        return "eventos";
    }

    @GetMapping("/eventos/nuevo")
    public String mostrarFormularioDeRegistrtarEventos(Model modelo) {
        Evento evento = new Evento();
        modelo.addAttribute("evento", evento);
        return "crear_evento";
    }

    @PostMapping("/eventos")
    public String guardarEvento(@ModelAttribute("evento") Evento evento) {
        servicio.guardarEvento(evento);
        return "redirect:/eventos";
    }

    @GetMapping({"/eventos/{id}"})
    public String listarEventosAdminId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("eventos", servicio.obtenerEventoPorId(id));
        return "eventos";
    }

    @GetMapping("/eventos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("evento", servicio.obtenerEventoPorId(id));
        return "editar_evento";
    }

    @PostMapping("/eventos/{id}")
    public String actualizarEvento(@PathVariable Long id, @ModelAttribute("evento") Evento evento, Model modelo) {
        Evento eventoExistente = servicio.obtenerEventoPorId(id);
        eventoExistente.setId(id);
        eventoExistente.setTitulo(evento.getTitulo());
        eventoExistente.setDescripcion(evento.getDescripcion());
        eventoExistente.setImagePath(evento.getImagePath());
        servicio.actualizarEvento(eventoExistente);
        return "redirect:/eventos";
    }

    @GetMapping("/eventos/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        servicio.eliminarEvento(id);
        return "redirect:/eventos";
    }
}