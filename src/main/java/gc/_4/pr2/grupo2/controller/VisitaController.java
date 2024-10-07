package gc._4.pr2.grupo2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo2.entity.Visita;
import gc._4.pr2.grupo2.service.IVisitaService;





@RestController
public class VisitaController {

	@Autowired
	private IVisitaService service;
		
	@GetMapping("/visita")
	public List<Visita> mostrarTodasLasVisitas(){
		return service.mostrarTodos();
	}
		
	@GetMapping("/visita/{id}")
	Visita mostrarVisitaPorId(@PathVariable("id") Long id){
		return service.mostrarVisitaPorId(id);
	}
		
	@PostMapping("/visita")
	Visita crearVisita(@RequestBody Visita VisitaDesdeElServicio){	
		return service.guardar(VisitaDesdeElServicio);
	}
		
	@PutMapping("/visitas")
	Visita actualizarVisita(@RequestBody Visita VisitaDesdeElServicio){
		return service.guardar(VisitaDesdeElServicio);
	}
		
	@DeleteMapping("/visitas/{id}")
	void borrarVisita(@PathVariable("id") Long id){
		service.eliminarPorId(id);
	}
	
}
