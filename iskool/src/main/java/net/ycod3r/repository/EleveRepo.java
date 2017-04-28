package net.ycod3r.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;

@Repository
public interface EleveRepo extends JpaRepository<Eleve, Long> {
	
	List<Eleve> findAllByOrderByNomAscPrenomAsc();
	
	List<Eleve> findByClasse(Classe classe);
	
	List<Eleve> findByClasseOrderByNomAscPrenomAsc(Classe classe);
	
	Long countByClasse(Classe classe);
	
	List<Eleve> findByClasseIdAndIdNotIn(Long id, Collection<Long> eleves);
	
	@Query("select n.eleve.id FROM Note n JOIN n.evaluation ev WHERE ev.id=?")
	List<Long> findElevesEvalues2(Long evaluationId);
	
	
	@Query("select n.eleve.id FROM Note n JOIN n.evaluation ev WHERE ev.id=?")
	Collection<Long> findElevesEvalues(Long evaluationId);

}
