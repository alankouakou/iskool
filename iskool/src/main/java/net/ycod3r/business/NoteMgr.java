package net.ycod3r.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Moyenne;
import net.ycod3r.domain.Note;
import net.ycod3r.repository.NoteRepo;

@Service
@Transactional
public class NoteMgr {

	@Autowired
	private NoteRepo noteRep;
	
	public Long countByEleve(Eleve eleve){
		return noteRep.countByEleve(eleve);
	}

	public List<Note> findByEvaluation(Evaluation evaluation) {
		return noteRep.findByEvaluation(evaluation);
	}

	long countByEvaluation(Evaluation evaluation) {
		return noteRep.countByEvaluation(evaluation);
	}

	public List<Note> findByEvaluationOrderByValeurDesc(Evaluation evaluation) {
		return findByEvaluationOrderByValeurDesc(evaluation);
	}

	public List<Long> eleveEvalues(Long evaluationId) {
		return noteRep.elevesEvalues(evaluationId);
	}
	
	public List<Note> findByEleve(Eleve eleve){
		return noteRep.findByEleve(eleve);
	}
	
	public List<Note> findByEleveId(Long id){
		return noteRep.findByEleveId(id);
	}

	public List<Note> findAll() {
		return noteRep.findAll();
	}

	public Note findOne(long id) {
		return noteRep.findOne(id);
	}

	public void save(Note note) {
		noteRep.save(note);
		
	}

	public List<Moyenne> findMoyennes() {
		return noteRep.findMoyennes();
	}

	public void delete(long id) {
		noteRep.delete(id);
	}

	public List<Moyenne> findMoyennesByClasseId(Long id) {
		return noteRep.findMoyennesByClasseId(id);
	}
	
	public Moyenne findMoyenneByEleveId(Long id){
		return noteRep.findMoyenneByEleveId(id);
	}

}
