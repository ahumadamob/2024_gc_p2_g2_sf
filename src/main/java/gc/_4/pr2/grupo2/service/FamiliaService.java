package gc._4.pr2.grupo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.repository.FamiliaRepository;

@Service
public class FamiliaService {
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	public Familia saveFamilia(Familia familia) {
		return familiaRepository.save(familia);
	}

}
