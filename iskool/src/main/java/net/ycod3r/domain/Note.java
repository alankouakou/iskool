package net.ycod3r.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date date;
	private Double valeur;
	private String observations;
	@ManyToOne(cascade={CascadeType.REMOVE, CascadeType.MERGE})
	private Evaluation evaluation;
	@ManyToOne
	private Eleve eleve;

	public Note(){}

	public Note(double valeur, Eleve eleve, Evaluation evaluation) {
		super();
		this.date = new Date();
		this.valeur = valeur;
		this.eleve = eleve;
		this.evaluation = evaluation;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	public Double getNotePonderee(){
		return valeur * evaluation.getTypeEvaluation().getPonderation();
	}
	
	public Double getCoefficient(){
		return evaluation.getTypeEvaluation().getPonderation();
	}

	@Override
	public String toString() {
		return "Note [eleve=" + eleve + ", valeur=" + valeur + "]";
	}
	
	
}
