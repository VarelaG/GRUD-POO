package com.crud.demo.servicio;

import com.crud.demo.controlador.dto.UsuarioRegistroDTO;
import com.crud.demo.modelo.Usuario;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService{

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();

}