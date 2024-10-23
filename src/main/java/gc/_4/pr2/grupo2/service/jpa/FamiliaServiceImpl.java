package gc._4.pr2.grupo2.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.repository.FamiliaRepository;
import gc._4.pr2.grupo2.service.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {
	
	@Autowired
	private FamiliaRepository repository;

	@Override
	public List<Familia> getFamilia() {
		return repository.findAll();
	}
	
	@Override
	public Familia getFamiliaById(Long id) {
	    return repository.findById(id).orElse(null);
	}
	
	@Override
	public Familia saveFamilia(Familia familia) {
		return repository.save(familia);
	}

	@Override
	public void deteleFamiliaById(Long id) {
		repository.deleteById(id);
	}
}
