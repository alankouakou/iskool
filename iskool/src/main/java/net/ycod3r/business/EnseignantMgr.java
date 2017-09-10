package net.ycod3r.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Enseignant;
import net.ycod3r.repository.EnseignantRepo;

@Service
@Transactional
public class EnseignantMgr {
	
	@Autowired
	private EnseignantRepo enseignantRepo;
	
	public List<Enseignant> findAllByOrderByNomAscPrenomAsc(){
		return enseignantRepo.findAllByOrderByNomAscPrenomAsc();
	}

	public void save(Enseignant enseignant) {
		enseignantRepo.save(enseignant);
	}

	public Enseignant findOne(long id) {
		// TODO Auto-generated method stub
		return enseignantRepo.findOne(id);
	}

	public void delete(long id) {
		enseignantRepo.delete(id);
		
	};
	

}
