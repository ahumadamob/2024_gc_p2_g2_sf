package gc._4.pr2.grupo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Familia;
import gc._4.pr2.grupo2.service.jpa.FamiliaDTO;

@Service
public interface FamiliaService {

	List<Familia> getFamilia();

    Familia getFamiliaById(Long id);

    Familia saveFamilia(Familia familia);
    
    boolean deleteFamiliaById(Long id);
    
    public boolean existe(Long id);
    
    List<Familia> findByRelacionIn(List<String> relaciones);

	List<FamiliaDTO> findByViveEnPropiedad(Boolean viveEnPropiedad);
}
