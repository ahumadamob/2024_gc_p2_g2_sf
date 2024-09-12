package gc._4.pr2.grupo2.service;

import gc._4.pr2.grupo2.entity.Mascota;
import java.util.List;
import java.util.Optional;

public interface MascotaService {
    Mascota guardarMascota(Mascota mascota);
    List<Mascota> obtenerTodasLasMascotas();
    Optional<Mascota> obtenerMascotaPorId(Long id);
    void eliminarMascota(Long id);
}