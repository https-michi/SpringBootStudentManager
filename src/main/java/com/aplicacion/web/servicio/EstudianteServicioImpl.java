package com.aplicacion.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.web.entidad.Estudiante;
import com.aplicacion.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public List<Estudiante> listarEstudiantes() {
		return repositorio.findAll();
	}

	@Override
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(Long Id) {
		return repositorio.findById(Id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public void eliminarEstudiante(Long Id) {
		repositorio.deleteById(Id);
	}

}
