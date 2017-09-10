package net.ycod3r.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Enseignant;
import net.ycod3r.domain.Enseignant;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
	
	List<Enseignant> findAllByOrderByNomAscPrenomAsc();
	


}
