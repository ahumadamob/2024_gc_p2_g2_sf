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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import gc._4.pr2.grupo2.entity.Visita;
import gc._4.pr2.grupo2.service.IVisitaService;
import gc._4.pr2.grupo2.dto.DTOVisita;



@RestController

@RequestMapping("/api")
public class VisitaController {

    @Autowired
    private IVisitaService visitaService;


 
    @PostMapping ("/visita")
    public DTOVisita<Visita> guardarVisita(@RequestBody Visita visita) {
    	if(visitaService.existe(visita.getId()))	{
    		return new DTOVisita<Visita>(false, "Este ID ya existe", null);
    	}else {
    		return new DTOVisita<Visita>(true, "Visita creado con Exito", visitaService.guardarVisita(visita));
    	}

    }
  //Ejemplo de instancia e inicializacion de un objeto

    @GetMapping ("/visita")
    public ResponseEntity<DTOVisita<List<Visita>>> obtenerTodasLasVisitas() {
        List<Visita> Visita = visitaService.obtenerTodasLasVisitas();
        if (Visita.isEmpty()) {
            return ResponseEntity.ok(new DTOVisita<>(false, "No hay visita disponibles", null));
        }
        return ResponseEntity.ok(new DTOVisita<>(true, "Visitas encontradas", Visita));
    }
   
    
    @GetMapping("/visita/{id}")
    public ResponseEntity<DTOVisita<Visita>> obtenerVisitaPorId(@PathVariable Long id) {
        Visita visita = visitaService.obtenerVisitaPorId(id);
        if (visita == null) {
            return ResponseEntity.ok(new DTOVisita<>(false, "Visita no encontrada", null));
        }
        return ResponseEntity.ok(new DTOVisita<>(true, "Visita encontrada", visita));
    }

  
    @PutMapping("/visita/{id}")
    public ResponseEntity<DTOVisita<Visita>> actualizarVisita(@PathVariable Long id, @RequestBody Visita visitaDetalles) {
        try {
            Visita visitaActualizada = visitaService.actualizarVisita(id, visitaDetalles);
            return ResponseEntity.ok(new DTOVisita<>(true, "Visita actualizada exitosamente", visitaActualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new DTOVisita<>(false, "visita inexistente", null));
        }
    }

   
    @DeleteMapping("/visita/{id}")
    public ResponseEntity<DTOVisita<Void>> eliminarVisita(@PathVariable Long id) {
        if (visitaService.obtenerVisitaPorId(id) == null) {
            return ResponseEntity.ok(new DTOVisita<>(false, "Visita no encontrada para eliminar", null));
        }
        visitaService.eliminarVisita(id);
       return ResponseEntity.ok(new DTOVisita<>(true, "Visita eliminada exitosamente", null));
        }	


	@GetMapping("/visita/exists/{id}")
	public ResponseEntity<Boolean> verificarExistencia(@PathVariable Long id) {
			boolean existe = visitaService.existe(id);
		return ResponseEntity.ok(existe);
	}
}