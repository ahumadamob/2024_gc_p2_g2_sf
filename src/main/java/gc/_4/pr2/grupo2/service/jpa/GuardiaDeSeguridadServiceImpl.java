package gc._4.pr2.grupo2.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.GuardiaDeSeguridad;
import gc._4.pr2.grupo2.repository.GuardiaDeSeguridadRepository;
import gc._4.pr2.grupo2.service.IGuardiaDeSeguridadService;


@Service
public class GuardiaDeSeguridadServiceImpl implements IGuardiaDeSeguridadService{

	@Autowired
	private GuardiaDeSeguridadRepository repo;

	public List<GuardiaDeSeguridad> mostrarTodos() {
		return repo.findAll();
	}

	public GuardiaDeSeguridad mostrarGuardiaPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	public GuardiaDeSeguridad guardar(GuardiaDeSeguridad guardia) {
		return repo.save(guardia);
	}

	public void eliminarPorId(Long id) {
		repo.deleteById(id);
	}
}
