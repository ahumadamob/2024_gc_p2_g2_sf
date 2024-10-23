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

import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.service.FamiliaService;

@RestController
public class FamiliaController {
	
	@Autowired
	private FamiliaService familiaService;

	@GetMapping("/familia")
	public List<Familia> obtenerFamilia(){
		return familiaService.getFamilia();
	}
	
	@GetMapping("familia/{id}")
	public Familia obtenerFamiliaPorId(@PathVariable Long id) {
	    return familiaService.getFamiliaById(id);
	}
	
	@PostMapping("familia")
	public Familia crearFamilia(@RequestBody Familia familia) {
	    return familiaService.saveFamilia(familia);
	}
	
	@PutMapping("/familia")
	public Familia actualizarFamilia(@RequestBody Familia familiaDesdeService){
		return familiaService.saveFamilia(familiaDesdeService);
	}
	
	@DeleteMapping("familia/{id}")
	public void eliminarFamiliaPorId(@PathVariable Long id) {
	    familiaService.deteleFamiliaById(id);
	}
	
}
