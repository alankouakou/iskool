package net.ycod3r.business;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Matiere;
import net.ycod3r.repository.MatiereRepo;

@Service
@Transactional
public class MatiereMgr {
	
	@Autowired
	private MatiereRepo matiereRep;
	
	public Matiere findOne(long id){
		return matiereRep.findOne(id);
	}
	
	public Matiere findByName(String name){
		return matiereRep.findByName(name);
	}

	public List<Matiere> findAll(){
		return matiereRep.findAll(new Sort("name"));
	}
	
	public void save(Matiere... matieres){
		matiereRep.save(Arrays.asList(matieres));
	}
	
	
	public void delete(Long id){
		matiereRep.delete(id);
	}
	
	
}
