package com.aplicacion.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aplicacion.web.entidad.Estudiante;
import com.aplicacion.web.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class SpringCrudCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudCliApplication.class, args);
	}

	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudiante estudiante1 = new Estudiante("Prueba", " Demo", " Demo@gmail.com");
		repositorio.save(estudiante1);
		Estudiante estudiante2 = new Estudiante("Demo", " Prueba", " Prueba@gmail.com");
		repositorio.save(estudiante2);
		*/
	}

}
