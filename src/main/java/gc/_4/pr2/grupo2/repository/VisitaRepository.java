package gc._4.pr2.grupo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gc._4.pr2.grupo2.entity.Visita;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long>{

}





