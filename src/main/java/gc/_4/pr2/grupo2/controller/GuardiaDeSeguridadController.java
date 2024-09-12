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

	import gc._4.pr2.grupo2.entity.GuardiaDeSeguridad;
	import gc._4.pr2.grupo2.service.IGuardiaDeSeguridadService;


	@RestController
	public class GuardiaDeSeguridadController {

	@Autowired
	private IGuardiaDeSeguridadService service;
		
	@GetMapping("/listar_guardias")
	public List<GuardiaDeSeguridad> mostrarTodosLosGuardias(){
		return service.mostrarTodos();
	}
		
	@GetMapping("/guardia/{id}")
	GuardiaDeSeguridad mostrarGuardiaPorId(@PathVariable("id") Long id){
		return service.mostrarGuardiaPorId(id);
	}
		
	@PostMapping("/crear_guardia")
	GuardiaDeSeguridad crearGuardia(@RequestBody GuardiaDeSeguridad GuardiaDeSeguridadDesdeElServicio){	
		return service.guardar(GuardiaDeSeguridadDesdeElServicio);
	}
		
	@PutMapping("/actualizar_guardia")
	GuardiaDeSeguridad actualizarGuardia(@RequestBody GuardiaDeSeguridad GuardiaDeSeguridadDesdeElServicio){
		return service.guardar(GuardiaDeSeguridadDesdeElServicio);
	}
		
	@DeleteMapping("/guardia/{id}")
	void borrarGuardia(@PathVariable("id") Long id){
		service.eliminarPorId(id);
	}
		
}

