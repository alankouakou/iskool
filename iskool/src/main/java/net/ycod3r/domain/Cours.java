package net.ycod3r.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Classe classe;
	private Date date;
	private Date heure_debut;
	private Date heure_fin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(Date heure_debut) {
		this.heure_debut = heure_debut;
	}

	public Date getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}

}
