package gc._4.pr2.grupo2.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo2.entity.Visita;
import gc._4.pr2.grupo2.repository.VisitaRepository;
import gc._4.pr2.grupo2.service.IVisitaService;




@Service
public class VisitaServiceImpl implements IVisitaService{



	 @Autowired
	    private VisitaRepository visitaRepository;
	    @Override
	    public Visita guardarVisita(Visita visita) {
	        return visitaRepository.save(visita);
	    }
	    //Se instancia el objeto visita de tipo List y se inicializa mediante el método "obtenerTodasLasVisitas"
	    
	    @Override
	    public List<Visita> obtenerTodasLasVisitas() {
	        return visitaRepository.findAll();
	    }

	    @Override
	  
	    public Visita obtenerVisitaPorId(Long id) {
	        return visitaRepository.findById(id).orElse(null);
	    }

	    @Override
	
	    public Visita actualizarVisita(Long id, Visita visitaDetalles) {
	         if (!visitaRepository.existsById(visitaDetalles.getId())) {
	        throw new RuntimeException("Visita no encontrada con id: " + visitaDetalles.getId());
	         }
	         return visitaRepository.save(visitaDetalles);
	      }
	    @Override
		public boolean existe(Long id) {
			if(id == null) {
				return false;
			}else {
				return visitaRepository.existsById(id);
			}
		}

	      @Override
	      public void eliminarVisita(Long id) {
	         visitaRepository.deleteById(id);
	      }
	  }









   