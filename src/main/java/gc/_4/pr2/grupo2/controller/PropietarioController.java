package gc._4.pr2.grupo2.controller;

import gc._4.pr2.grupo2.dto.DTOPropietario;
import gc._4.pr2.grupo2.entity.Propietario;
import gc._4.pr2.grupo2.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PropietarioController {

    @Autowired
    private IPropietarioService IPropietarioService;
    
  //Ejemplo de instancia de objeto en el controlador
    @PostMapping ("/propietario")
    public DTOPropietario<Propietario> guardarPropietario(@RequestBody Propietario propietario) {
        if(IPropietarioService.existe(propietario.getId()))    {
        	// Se crea una instancia de DTOPropietario que almacena el resultado de la operación
            return new DTOPropietario<Propietario>(false, "Este id ya existe", null);
         // Instancia del objeto DTOPropietario con valores de error
        }else {
        	// Instancia del objeto DTOPropietario con éxito y el propietario guardado
            return new DTOPropietario<Propietario>(true, "Propietario creado con Exito", IPropietarioService.guardar(propietario));
        }

    }
    @GetMapping ("/propietario")
    public ResponseEntity<DTOPropietario<List<Propietario>>> mostrar() {
        List<Propietario> propietario = IPropietarioService.mostrar();
        if (propietario.isEmpty()) {
            return ResponseEntity.ok(new DTOPropietario<>(false, "No hay propietarios disponibles", null));
        }
        return ResponseEntity.ok(new DTOPropietario<>(true, "Propietarios encontrados", propietario));
    }

    @GetMapping("/propietario/{id}")
    public ResponseEntity<DTOPropietario<Propietario>> mostrarPorId(@PathVariable Long id) {
    	Propietario propietario = IPropietarioService.mostrarPorId(id);
        if (propietario == null) {
            return ResponseEntity.ok(new DTOPropietario<>(false, "Propietario no encontrado", null));
        }
        return ResponseEntity.ok(new DTOPropietario<>(true, "Propietario Encontrado", propietario));
    }

 // Ejemplo de inicialización de un objeto en el método actualizarPropietario del controlador
    @PutMapping("/propietario/{id}")
    public ResponseEntity<DTOPropietario<Propietario>> actualizarPropietario(@PathVariable Long id, @RequestBody Propietario PropietarioDetalles) {
        try {
        	 // Se inicializa un objeto propietarioActualizado llamando al método actualizar en el servicio
        	Propietario propietarioActualizado = IPropietarioService.ActualizarPropietario(id, PropietarioDetalles);
            return ResponseEntity.ok(new DTOPropietario<>(true, "Propietario Actualizado", propietarioActualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new DTOPropietario<>(false, "Propietario no encontrado", null));
        }
    }

    @DeleteMapping("/propietario/{id}")
    public ResponseEntity<DTOPropietario<Void>> eliminarPropietario(@PathVariable Long id) {
        if (IPropietarioService.mostrarPorId(id) == null) {
            return ResponseEntity.ok(new DTOPropietario<>(false, "Propietario no encontrado para eliminar", null));
        }
        IPropietarioService.eliminarPorId(id);
        return ResponseEntity.ok(new DTOPropietario<>(true, "Propietario eliminado exitosamente", null));
    }
    @GetMapping("/propietario/existe/{id}")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
            boolean existe = IPropietarioService.existe(id);
        return ResponseEntity.ok(existe);
    }
}

