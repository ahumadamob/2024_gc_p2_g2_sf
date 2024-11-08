package gc._4.pr2.grupo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Familia;

@Service
public interface FamiliaService {

	public List<Familia> getFamilia();
	
	public Familia getFamiliaById(Long id);
	
	public Familia saveFamilia(Familia familia);

	public void deteleFamiliaById(Long id);
}
