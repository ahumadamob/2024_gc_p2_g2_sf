package gc._4.pr2.grupo2.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.repository.FamiliaRepository;
import gc._4.pr2.grupo2.service.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {

	// La variable repository es una instancia de la clase FamiliaRepository, que se utiliza para interactuar con la base de datos.
	
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
    public boolean deleteFamiliaById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

	@Override
	public boolean existe(Long id) {
		if(id == null) {
			return false;
		} else {
			return repository.existsById(id);
		}
	}
}