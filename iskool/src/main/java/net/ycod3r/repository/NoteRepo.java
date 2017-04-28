package net.ycod3r.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Moyenne;
import net.ycod3r.domain.Note;

public interface NoteRepo extends JpaRepository<Note, Long> {
	
	List<Note> findByEvaluation(Evaluation evaluation);
	
	List<Note> findByEleve(Eleve eleve);

	long countByEvaluation(Evaluation evaluation);
	List<Note> findByEvaluationOrderByValeurDesc(Evaluation evaluation);

	@Query("select n.eleve.id from Note n WHERE n.evaluation.id=?")
	List<Long> elevesEvalues(Long  evaluationId);
	
	@Query("Select new net.ycod3r.domain.Moyenne(n.eleve, AVG(n.valeur) as moyenne) FROM Note n WHERE n.eleve.id=?")
	Moyenne findMoyenneByEleveId(Long id);
	
	@Query("Select new net.ycod3r.domain.Moyenne(e, AVG(mark.valeur) as moyenne) FROM Eleve e JOIN e.notes mark")
	List<Moyenne> findAllMoyennes();
	
	@Query("Select new net.ycod3r.domain.Moyenne(n.eleve, AVG(n.valeur) as moyenne) FROM Note n GROUP BY n.eleve")
	List<Moyenne> findMoyennes();

	@Query("Select new net.ycod3r.domain.Moyenne(n.eleve, AVG(n.valeur) as moyenne) FROM Note n WHERE n.eleve.classe.id=:classeId GROUP BY n.eleve")
	List<Moyenne> findMoyennesByClasseId(@Param("classeId") Long classeId);

}
