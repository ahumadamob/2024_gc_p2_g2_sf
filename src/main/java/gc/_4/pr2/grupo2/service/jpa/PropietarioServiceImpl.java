package gc._4.pr2.grupo2.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Propietario;
import gc._4.pr2.grupo2.repository.PropietarioRepository;
import gc._4.pr2.grupo2.service.IPropietarioService;


@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private PropietarioRepository repo;

	public List<Propietario> mostrar() {
		return repo.findAll();
	}

	public Propietario mostrarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Propietario guardar(Propietario guardia) {
		return repo.save(guardia);
	}

	public void eliminarPorId(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public Propietario ActualizarPropietario(Long id,Propietario PropietarioDetalles) {
		if(!repo.existsById(PropietarioDetalles.getId())) {
			throw new RuntimeException("Propietario no encontrado por su id" + PropietarioDetalles.getId());
		}
		return repo.save(PropietarioDetalles);
	}

	@Override
    public boolean existe(Long id) {
        if(id == null) {
            return false;
        }else {
            return repo.existsById(id);
        }
    }
}
