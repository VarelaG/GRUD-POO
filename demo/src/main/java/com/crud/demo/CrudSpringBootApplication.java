package com.crud.demo;

import com.crud.demo.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.crud.demo.repositorio.EventoRepositorio;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Autowired
	private EventoRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*Evento evento1 = new Evento("titulo","descripcion");
		repositorio.save(evento1);

		Evento evento2 = new Evento("titulo2","descripcion2");
		repositorio.save(evento2);*/
	}
}
