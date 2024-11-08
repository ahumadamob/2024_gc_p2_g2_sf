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

	public GuardiaDeSeguridad actualizarGuardia(Long id, GuardiaDeSeguridad guardiaDetalles) {
		if (!repo.existsById(guardiaDetalles.getId())) {
			throw new RuntimeException("Guardia no encontrado con id: " + guardiaDetalles.getId());
		}
		return repo.save(guardiaDetalles);
	}


	public boolean existe(Long id) {
		if(id == null) {
			return false;
		}else {
			return repo.existsById(id);
		}
	}

	public void eliminarPorId(Long id) {
		repo.deleteById(id);
	}
}
