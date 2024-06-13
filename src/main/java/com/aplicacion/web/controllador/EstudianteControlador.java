package com.aplicacion.web.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aplicacion.web.entidad.Estudiante;
import com.aplicacion.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/estudiantes", "/" })
	public String listarEstudiante(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarEstudiantes());
		return "crud/estudiantes";
	}

	@GetMapping({ "/estudiantes/nuevo" })
	public String mostrarFormularioRegistroEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crud/crear_estudiante";
	}

	@PostMapping("/crearEstudiante")
	public String crearEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.crearEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/actualizar/{id}")
	public String mostrarFormularioActualizar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		return "crud/actualizar_estudiante";
	}

	@PostMapping("/actualizarEstudiante/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		servicio.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";

	}

	@GetMapping("/eliminarEstudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
}
