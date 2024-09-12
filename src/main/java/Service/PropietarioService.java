package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Propietario;
import repository.PropietarioRepository;

import java.util.List;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> obtenerTodosLosPropietarios() {
        return propietarioRepository.findAll();
    }

    public Propietario guardarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public void eliminarPropietario(Long id) {
        propietarioRepository.deleteById(id);
    }
}
