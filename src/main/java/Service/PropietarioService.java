package Service;

import gc._4.pr2.grupo2.entity.Propietario;

import java.util.List;

public interface PropietarioService {

    List<Propietario> obtenerTodosLosPropietarios();
    Propietario guardarPropietario(Propietario propietario);
    void eliminarPropietario(Long id);
    Propietario obtenerPropietarioPorId(Long id);
}
