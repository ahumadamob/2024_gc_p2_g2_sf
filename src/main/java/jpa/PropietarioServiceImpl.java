package jpa;

import repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Propietario;

import java.util.List;

@Service
public class PropietarioServiceImpl {

    @Autowired
    private PropietarioRepository propietarioRepository;

    // Obtener todos los propietarios
    public List<Propietario> obtenerTodosLosPropietarios() {
        return propietarioRepository.findAll();
    }

    // Guardar un nuevo propietario
    public Propietario guardarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    // Eliminar un propietario por ID
    public void eliminarPropietario(Long id) {
        propietarioRepository.deleteById(id);
    }

    // Buscar un propietario por ID
    public Propietario obtenerPropietarioPorId(Long id) {
        return propietarioRepository.findById(id).orElse(null);
    }
}

