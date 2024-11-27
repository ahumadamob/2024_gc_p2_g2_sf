package gc._4.pr2.grupo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo2.entity.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Long>{

	// Método para realizar el filtro por relacion "Padre" o "Madre"
	List<Familia> findByRelacionIn(List<String> relaciones);
	
	// // Método para realizar el filtro por viveEnPropiedad true o false
	List<Familia> findByViveEnPropiedad(Boolean viveEnPropiedad);
	
	

}
