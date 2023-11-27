package com.crud.demo.servicio;

import com.crud.demo.entidad.Evento;

import java.util.List;

public interface EventoServicio {

    public List<Evento> listarEventos();

    public Evento guardarEvento(Evento evento);

    public Evento obtenerEventoPorId(Long id);

    public Evento actualizarEvento(Evento evento);

    public void eliminarEvento(Long id);
}
