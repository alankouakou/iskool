package net.ycod3r.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Classe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToOne
	private Niveau niveau;
	@ManyToOne
	private AnneeAcademique anneeAcademique;
	
	@OneToMany(mappedBy="classe")
	private List<Eleve> eleves;
	
	
	@OneToMany(mappedBy="classe")
	private List<Evaluation> evaluations;
	
	public Classe(){}
	
	public Classe(String name) {
		super();
		this.name = name;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	
	public void addEvaluation(Evaluation evaluation){
		this.evaluations.add(evaluation);
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	public List<Eleve> getEleves() {
		return eleves;
	}

	public void addEleve(Eleve eleve){
		this.eleves.add(eleve);
	}
	
	public void removeEleve(Eleve eleve){
		if(this.eleves.contains(eleve))
			this.eleves.remove(eleve);
	}
	
	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	
	

}
