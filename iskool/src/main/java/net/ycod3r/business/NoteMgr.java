package net.ycod3r.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Note;
import net.ycod3r.repository.NoteRepo;

@Service
@Transactional
public class NoteMgr {

	@Autowired
	private NoteRepo noteRep;

	List<Note> findByEvaluation(Evaluation evaluation) {
		return noteRep.findByEvaluation(evaluation);
	}

	long countByEvaluation(Evaluation evaluation) {
		return noteRep.countByEvaluation(evaluation);
	}

	List<Note> findByEvaluationOrderByValeurDesc(Evaluation evaluation) {
		return findByEvaluationOrderByValeurDesc(evaluation);
	}

	List<Long> eleveEvalues(Long evaluationId) {
		return noteRep.elevesEvalues(evaluationId);
	}
	
	List<Note> findByEleve(Eleve eleve){
		return noteRep.findByEleve(eleve);
	}

}
