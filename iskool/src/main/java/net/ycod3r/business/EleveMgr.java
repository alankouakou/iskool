package net.ycod3r.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.repository.EleveRepo;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.repository.NoteRepo;

@Service
@Transactional
public class EleveMgr {

	@Autowired
	private EleveRepo eleveRep;
	
	@Autowired
	private EvaluationRepo evaluationRep;
	
	@Autowired
	private NoteRepo noteRep;
	
	public Eleve findOne(Long id){
		return eleveRep.findOne(id);
	}
	
	public List<Eleve> findAllByOrderByNomAscPrenomAsc(){
		return eleveRep.findAllByOrderByNomAscPrenomAsc();
	};
	
	public List<Eleve> findByClasse(Classe classe){
		return eleveRep.findByClasse(classe);
	};
	
	public List<Eleve> findByClasseOrderByNomAscPrenomAsc(Classe classe){
		return eleveRep.findByClasseOrderByNomAscPrenomAsc(classe);
	};
	
	public Long countByClasse(Classe classe){
		return eleveRep.countByClasse(classe);
	};
	
	public List<Eleve> findNonEvaluesByEvaluationId(Long evaluationId){
		List<Eleve> nonEvalues = new ArrayList<Eleve>();
		
		Collection<Long> evalues =  eleveRep.findElevesEvalues(evaluationId);
		Classe classe = evaluationRep.findOne(evaluationId).getClasse();
		
		if(evalues.size() == 0){
			nonEvalues = eleveRep.findByClasse(classe);
		} else {
			nonEvalues = eleveRep.findByClasseIdAndIdNotIn(classe.getId(), evalues);
		}
			
		List<Long> idEvalues = eleveRep.findElevesEvalues2(evaluationId);
		System.out.println(idEvalues);
		System.out.println(nonEvalues);
		return nonEvalues;
	};	
	
	
	
}
