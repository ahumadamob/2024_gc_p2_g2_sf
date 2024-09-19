package gc._4.pr2.grupo2.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Visita;
import gc._4.pr2.grupo2.repository.VisitaRepository;
import gc._4.pr2.grupo2.service.IVisitaService;


@Service
public class VisitaServiceImpl implements IVisitaService{

	@Autowired
	private VisitaRepository repo;

	public List<Visita> mostrarTodos() {
		return repo.findAll();
	}

	public Visita mostrarVisitaPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Visita guardar(Visita visita) {
		return repo.save(visita);
	}

	public void eliminarPorId(Long id) {
		repo.deleteById(id);
	}

}
