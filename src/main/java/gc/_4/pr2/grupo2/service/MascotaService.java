package gc._4.pr2.grupo2.service;

import gc._4.pr2.grupo2.entity.Mascota;
import java.util.List;


public interface MascotaService {
    Mascota guardarMascota(Mascota mascota);
    List<Mascota> obtenerTodasLasMascotas();
    Mascota obtenerMascotaPorId(Long id);
    Mascota actualizarMascota(Long id, Mascota mascotaDetalles);
    void eliminarMascota(Long id);
    public boolean existe(Long id);

}