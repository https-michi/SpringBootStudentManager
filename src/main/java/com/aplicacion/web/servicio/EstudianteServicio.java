package com.aplicacion.web.servicio;

import java.util.List;

import com.aplicacion.web.entidad.Estudiante;

public interface EstudianteServicio {

	public List<Estudiante> listarEstudiantes();
	public Estudiante crearEstudiante(Estudiante estudiante);
	public Estudiante obtenerEstudiantePorId(Long Id);
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	public void eliminarEstudiante(Long Id);
		
	
}
