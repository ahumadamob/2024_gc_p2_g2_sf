package gc._4.pr2.grupo2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.RespuestaDTO;
import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.service.FamiliaService;

@RestController
public class FamiliaController {

	// La variable familiaService se inicializa automáticamente por Spring gracias a la anotación @Autowired.
	
    @Autowired
    private FamiliaService familiaService;

    // Obtener todas las familias
    @GetMapping("/familia")
    public RespuestaDTO<List<Familia>> obtenerFamilias() {
        List<Familia> familias = familiaService.getFamilia();
        RespuestaDTO<List<Familia>> respuesta = new RespuestaDTO<>();
        respuesta.setEstado(true);
        respuesta.setMensaje("Familias encontradas");
        respuesta.setData(familias);
        return respuesta;
    }

    // Obtener una familia por ID
    @GetMapping("/familia/{id}")
    public RespuestaDTO<Familia> obtenerFamiliaPorId(@PathVariable Long id) {
        Familia familia = familiaService.getFamiliaById(id);
        RespuestaDTO<Familia> respuesta = new RespuestaDTO<>();
        if (familia != null) {
            respuesta.setEstado(true);
            respuesta.setMensaje("Familia encontrada");
            respuesta.setData(familia);
        } else {
            respuesta.setEstado(false);
            respuesta.setMensaje("Familia no encontrada");
        }
        return respuesta;
    }
    
    // Obtener familiar cuya propiedad "relación" sea "Padre" o "Madre"
    @GetMapping("/familias/padresMadres")
    public RespuestaDTO<List<Familia>> obtenerFamiliaSegunRelacion() {
    	List<String> relaciones = Arrays.asList("Padre", "Madre");
        List<Familia> familias = familiaService.findByRelacionIn(relaciones);
        RespuestaDTO<List<Familia>> respuesta = new RespuestaDTO<>();
        respuesta.setEstado(true);
        respuesta.setMensaje("Familias encontradas");
        respuesta.setData(familias);
        return respuesta;
    }
    
    // Obtener familiares propietarios
    @GetMapping("/padresMadres/propietarios")
    public RespuestaDTO<List<Familia>> getFamiliasPropietarias(@RequestParam(required = false) Boolean viveEnPropiedad) {
        List<Familia> familias = familiaService.findByViveEnPropiedad(viveEnPropiedad);

        RespuestaDTO<List<Familia>> respuesta = new RespuestaDTO<>();
        respuesta.setEstado(true);
        respuesta.setMensaje("Familias encontradas");
        respuesta.setData(familias);

        return respuesta;
    }
    
    /*	Obtener todas las familias: GET /padresMadres/propietarios
    	Obtener solo las familias propietarias: GET /padresMadres/propietarios?viveEnPropiedad=true
    	Obtener solo las familias que no son propietarias: GET /padresMadres/propietarios?viveEnPropiedad=false
    */

    // Crear una nueva familia
    @PostMapping("/familia")
    public RespuestaDTO<Familia> crearFamilia(@RequestBody Familia familia) {
    	RespuestaDTO<Familia> respuesta = new RespuestaDTO<>();
    	if(familiaService.existe(familia.getId())) {
    		// Si el id existe, no se crea, doy error
            respuesta.setEstado(false);
            respuesta.setMensaje("No se pudo crear la familia");
    		
    	}else {
    		// Si no existe, lo creo
    		Familia familiaGuardada = familiaService.saveFamilia(familia);
    		respuesta.setEstado(true);
            respuesta.setMensaje("Familia creada correctamente");
            respuesta.setData(familiaGuardada);
    	}
        return respuesta;
    }
    
    // Actualizar una familia
    @PutMapping("/familia")
    public RespuestaDTO<Familia> actualizarFamilia(@RequestBody Familia familia) {
    	RespuestaDTO<Familia> respuesta = new RespuestaDTO<>();
    	if(familiaService.existe(familia.getId())) {
    		// Si existe lo actualizo
    		Familia familiaGuardada = familiaService.saveFamilia(familia);
    		respuesta.setEstado(true);
            respuesta.setMensaje("Familia actualizada correctamente");
            respuesta.setData(familiaGuardada);  		
    		
    	}else {
    		// Si no existe doy el error
            respuesta.setEstado(false);
            respuesta.setMensaje("No se pudo actualizar la familia");
    		
    	}
        return respuesta;
    }

    // Eliminar una familia
    @DeleteMapping("/familia/{id}")
    public RespuestaDTO<String> eliminarFamilia(@PathVariable Long id) {
        boolean eliminado = familiaService.deleteFamiliaById(id);
        RespuestaDTO<String> respuesta = new RespuestaDTO<>();
        if (eliminado) {
            respuesta.setEstado(true);
            respuesta.setMensaje("Familia eliminada correctamente");
        } else {
            respuesta.setEstado(false);
            respuesta.setMensaje("No se pudo eliminar la familia");
        }
        return respuesta;
    }
}
