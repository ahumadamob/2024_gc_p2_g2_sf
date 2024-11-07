package gc._4.pr2.grupo2.controller;

import gc._4.pr2.grupo2.dto.DTOMascota;
import gc._4.pr2.grupo2.entity.Mascota;
import gc._4.pr2.grupo2.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping ("/mascotas")
    public DTOMascota<Mascota> guardarMascota(@RequestBody Mascota mascota) {
    	if(mascotaService.existe(mascota.getId()))	{
    		return new DTOMascota<Mascota>(false, "Este ID ya existe", null);
    	}else {
    		return new DTOMascota<Mascota>(true, "Mascota creado con Exito", mascotaService.guardarMascota(mascota));
    	}
    	
    }
        
    
    
    @GetMapping ("/mascotas")
    public ResponseEntity<DTOMascota<List<Mascota>>> obtenerTodasLasMascotas() {
        List<Mascota> mascotas = mascotaService.obtenerTodasLasMascotas();
        if (mascotas.isEmpty()) {
            return ResponseEntity.ok(new DTOMascota<>(false, "No hay mascotas disponibles", null));
        }
        return ResponseEntity.ok(new DTOMascota<>(true, "Mascotas encontradas", mascotas));
    }
    
    @GetMapping("/mascotas/{id}")
    public ResponseEntity<DTOMascota<Mascota>> obtenerMascotaPorId(@PathVariable Long id) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        if (mascota == null) {
            return ResponseEntity.ok(new DTOMascota<>(false, "Mascota no encontrada", null));
        }
        return ResponseEntity.ok(new DTOMascota<>(true, "Mascota encontrada", mascota));
    }

    @PutMapping("/mascotas/{id}")
    public ResponseEntity<DTOMascota<Mascota>> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascotaDetalles) {
        try {
            Mascota mascotaActualizada = mascotaService.actualizarMascota(id, mascotaDetalles);
            return ResponseEntity.ok(new DTOMascota<>(true, "Mascota actualizada exitosamente", mascotaActualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new DTOMascota<>(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/mascotas/{id}")
    public ResponseEntity<DTOMascota<Void>> eliminarMascota(@PathVariable Long id) {
        if (mascotaService.obtenerMascotaPorId(id) == null) {
            return ResponseEntity.ok(new DTOMascota<>(false, "Mascota no encontrada para eliminar", null));
        }
        mascotaService.eliminarMascota(id);
        return ResponseEntity.ok(new DTOMascota<>(true, "Mascota eliminada exitosamente", null));
    	}	
	

	@GetMapping("/mascotas/exists/{id}")
	public ResponseEntity<Boolean> verificarExistencia(@PathVariable Long id) {
			boolean existe = mascotaService.existe(id);
		return ResponseEntity.ok(existe);
	}
}
