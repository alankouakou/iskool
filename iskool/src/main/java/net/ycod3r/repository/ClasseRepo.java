package net.ycod3r.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ycod3r.domain.Classe;

@Repository
public interface ClasseRepo extends JpaRepository<Classe, Long> {

	List<Classe> findAllByOrderByNameAsc();

	Classe findByName(String classeName);


	
	

}
