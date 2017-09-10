package net.ycod3r.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Double coefficient;
	@OneToMany(mappedBy="matiere")
	private List<Evaluation> evaluations;
	@ManyToMany(mappedBy="matieres")
	private Collection<Enseignant> enseignants;
	
	

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matiere(String name, double coeff) {
		this.name= name;
		this.coefficient = coeff;
	}
	
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
	public Double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	@Override
	public String toString() {
		return name;
	}

	public void addEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		enseignants.add(enseignant);
	}

}
