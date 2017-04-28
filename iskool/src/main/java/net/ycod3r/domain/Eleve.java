package net.ycod3r.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Eleve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Size(min=2, message="Longueur minimum : 2")
	private String nom;
	@Size(min=3, message="Longueur minimum : 3")
	private String prenom;
	@NotNull @Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateNaissance;
	@ManyToOne
	private Classe classe;
	
	@OneToMany(mappedBy="eleve")
	Set<Note> notes = new HashSet<Note>();
	
	public Eleve(){}
	
	public Eleve(String nom, String prenom, Date dateNaissance, Classe classe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.classe = classe;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Set<Note> getNotes() {
		return notes;
	}
	
	public void addNote(Note note){
		this.notes.add(note);
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return nom + " " + prenom ;
	}

}
