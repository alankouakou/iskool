package net.ycod3r.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cycle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy="cycle")
	private Collection<Niveau> niveaux;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Niveau> getNiveaux() {
		return niveaux;
	}
	public void setNiveaux(Collection<Niveau> niveaux) {
		this.niveaux = niveaux;
	}
	
	
}
