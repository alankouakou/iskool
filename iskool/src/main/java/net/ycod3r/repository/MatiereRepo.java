package net.ycod3r.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.domain.Matiere;

public interface MatiereRepo extends JpaRepository<Matiere,Long> {

	Matiere findByName(String name);

	List<Matiere> findAllByOrderByNameAsc();
	
}
