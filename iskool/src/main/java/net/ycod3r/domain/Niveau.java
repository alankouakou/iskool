package net.ycod3r.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Niveau {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libelle;
	@ManyToOne
	private Cycle cycle;

	@OneToMany(mappedBy="niveau")
	private Collection<Classe> classes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Cycle getCycle() {
		return cycle;
	}
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	
	public void addClasse(Classe classe){
		classes.add(classe);
		classe.setNiveau(this);
	}
	
	public void removeClasse(Classe classe){
		classes.remove(classe);
		classe.setNiveau(null);
	}
	
	public Collection<Classe> getClasses() {
		return classes;
	}
	
	public void setClasses(Collection<Classe> classes) {
		this.classes = classes;
	}
	
	

}
