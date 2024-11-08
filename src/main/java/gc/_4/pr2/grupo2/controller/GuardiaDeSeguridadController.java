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
import gc._4.pr2.grupo2.dto.DTOGuardiaDeSeguridad;
import gc._4.pr2.grupo2.entity.GuardiaDeSeguridad;
import gc._4.pr2.grupo2.service.IGuardiaDeSeguridadService;
import org.springframework.http.ResponseEntity;


@RestController
public class GuardiaDeSeguridadController {

	@Autowired
	private IGuardiaDeSeguridadService service;

	//REDI
	@GetMapping ("/guardias")
	public ResponseEntity<DTOGuardiaDeSeguridad<List<GuardiaDeSeguridad>>> mostrarTodos() {
		List<GuardiaDeSeguridad> guardiaDeSeguridad = service.mostrarTodos();
		if (guardiaDeSeguridad.isEmpty()){
			return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(false, "No hay guardias cargados", null));
		}
		return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(true, "Guardias encontrados", guardiaDeSeguridad));
	}

	//REDI
	@GetMapping("/guardias/{id}")
	public ResponseEntity<DTOGuardiaDeSeguridad<GuardiaDeSeguridad>> mostrarGuardiaPorId(@PathVariable Long id) {
		GuardiaDeSeguridad guardiaDeSeguridad = service.mostrarGuardiaPorId(id);
		if (guardiaDeSeguridad == null) {
			return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(false, "Guardia no encontrado", null));
		}
		return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(true, "Guardia encontrado", guardiaDeSeguridad));
	}
	
	//REDI
	@PostMapping ("/guardias")
	public DTOGuardiaDeSeguridad<GuardiaDeSeguridad> guardarGuardiaDeSeguridad(@RequestBody GuardiaDeSeguridad guardiaDeSeguridad) {
		if(service.existe(guardiaDeSeguridad.getId())){
			return new DTOGuardiaDeSeguridad<GuardiaDeSeguridad>(false, "Este ID ya existe", null);
		}else {
			return new DTOGuardiaDeSeguridad<GuardiaDeSeguridad>(true, "Guardia creado con Exito", service.guardar(guardiaDeSeguridad));
		}
	}

	@PutMapping("/guardias/{id}")
	public ResponseEntity<DTOGuardiaDeSeguridad<GuardiaDeSeguridad>> actualizarGuardia(@PathVariable Long id, @RequestBody GuardiaDeSeguridad guardiaDetalles) {
        try {
        	GuardiaDeSeguridad guardiaActualizado = service.actualizarGuardia(id, guardiaDetalles);
            return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(true, "Guardia Actualizado", guardiaActualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new DTOGuardiaDeSeguridad<>(false, "Guardia no encontrado", null));
        }
    }
	//REDI
	/*@PutMapping("/guardias/{id}")
	GuardiaDeSeguridad actualizarGuardia(@RequestBody GuardiaDeSeguridad GuardiaDeSeguridadDesdeElServicio){
		return service.guardar(GuardiaDeSeguridadDesdeElServicio);
	}
	public ResponseEntity<DTOGuardiaDeSeguridad<GuardiaDeSeguridad>> actualizarGuardiaDeSeguridad(@PathVariable Long id, @RequestBody GuardiaDeSeguridad GuardiaDeSeguridadDetalles) {
		try {
			GuardiaDeSeguridad guardiaActualizado = service.actualizarGuardia(id, GuardiaDeSeguridadDetalles);
			return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(true, "Guardia actualizado exitosamente", guardiaActualizado));
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(new DTOGuardiaDeSeguridad<>(false, e.getMessage(), null));
		}
	}*/

	//REDI
	@DeleteMapping("/guardias/{id}")
	public ResponseEntity<DTOGuardiaDeSeguridad<Void>> eliminarPorId(@PathVariable Long id) {
		if (service.mostrarGuardiaPorId(id) == null) {
			return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(false, "Guardia no encontrado para eliminar", null));
		}
		service.eliminarPorId(id);
		return ResponseEntity.ok(new DTOGuardiaDeSeguridad<>(true, "Guardia eliminado exitosamente", null));
	}	

	//REDI
	@GetMapping("/guardias/existe/{id}")
	public ResponseEntity<Boolean> verificarExistencia(@PathVariable Long id) {
		boolean existe = service.existe(id);
		return ResponseEntity.ok(existe);
	}
}

