package gc._4.pr2.grupo2.service.jpa;

import gc._4.pr2.grupo2.entity.Mascota;
import gc._4.pr2.grupo2.repository.MascotaRepository;
import gc._4.pr2.grupo2.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
public Mascota actualizarMascota(Long id, Mascota mascotaDetalles) {
     mascotaDetalles.setId(id);
     return mascotaRepository.save(mascotaDetalles);
}
          
    @Override
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}