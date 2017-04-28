package net.ycod3r.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Classe;
import net.ycod3r.repository.ClasseRepo;

@Service
@Transactional
public class ClasseMgr {
	
	@Autowired
	private ClasseRepo classeRep;
	
	List<Classe> findAllByOrderByNameAsc(){
		return classeRep.findAllByOrderByNameAsc();
	}

	Classe findByName(String classeName){
		return classeRep.findByName(classeName);
	}
	

}
