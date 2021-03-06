package net.ycod3r.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateEvaluation;
	
	@ManyToOne
	private Matiere matiere;

	@ManyToOne
	private Classe classe;
	
	@ManyToOne
	private TypeNote typeEvaluation;
	@Enumerated(EnumType.STRING)
	private StatutEvaluation statut; 
	
	private Date dateMaj;
	
	@OneToMany(mappedBy="evaluation", orphanRemoval=true)
	Set<Note> notes = new HashSet<Note>();
	
	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	
	
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}	
	
	public Evaluation() {
		this.dateMaj= new Date();
		this.statut = StatutEvaluation.NOUVEAU;
	}
	
	public Evaluation(Date dateEvaluation, Classe classe, Matiere matiere, TypeNote typeEvaluation) {
		super();
		this.dateEvaluation = dateEvaluation;
		this.classe = classe;
		this.matiere  = matiere;
		this.typeEvaluation = typeEvaluation;
		this.dateMaj = new Date();
		this.statut = StatutEvaluation.PLANIFIE;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateEvaluation() {
		return dateEvaluation;
	}
	
	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
		this.statut = StatutEvaluation.PLANIFIE;
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public TypeNote getTypeEvaluation() {
		return typeEvaluation;
	}
	
	public void setTypeEvaluation(TypeNote typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}
	
	public StatutEvaluation getStatut() {
		return statut;
	}

	public void setStatut(StatutEvaluation statut) {
		this.statut = statut;
	}

	public Date getDateMaj() {
		return dateMaj;
	}
	
	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	@Override
	public String toString() {
		return typeEvaluation.getName() + " du " + dateEvaluation + ", classe=" + classe ;
	}

	
}
