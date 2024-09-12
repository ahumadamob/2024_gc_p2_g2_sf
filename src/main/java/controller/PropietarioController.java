package controller;


	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.PropietarioService;
import gc._4.pr2.grupo2.entity.Propietario;

	@RestController
	@RequestMapping("/api/propietarios")
	public class PropietarioController {

	    @Autowired
	    private PropietarioService propietarioService;

	    @GetMapping
	    public List<Propietario> obtenerTodosLosPropietarios() {
	        return propietarioService.obtenerTodosLosPropietarios();
	    }

	    @PostMapping
	    public Propietario guardarPropietario(@RequestBody Propietario propietario) {
	        return propietarioService.guardarPropietario(propietario);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminarPropietario(@PathVariable Long id) {
	        propietarioService.eliminarPropietario(id);
	    }
	}
