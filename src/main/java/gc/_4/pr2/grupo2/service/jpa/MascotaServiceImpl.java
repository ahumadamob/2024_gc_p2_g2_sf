package gc._4.pr2.grupo2.service.jpa;

import gc._4.pr2.grupo2.entity.Mascota;
import gc._4.pr2.grupo2.repository.MascotaRepository;
import gc._4.pr2.grupo2.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Mascota> obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
