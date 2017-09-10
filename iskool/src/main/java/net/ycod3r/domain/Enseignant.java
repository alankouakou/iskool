package net.ycod3r.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	private Date dateNaissance;
	private String adresse;
	private String telephoneMobile;
	private String telephoneFixe;
	private String email;
	@ManyToMany
	private Collection<Matiere> matieres;
	
	public Enseignant(){
		
	}
	
	public Enseignant(String nom, String prenom, Civilite civilite, Date dateNaissance, String mobile, String fixe, String email){
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.dateNaissance = dateNaissance;
		this.telephoneMobile = mobile;
		this.telephoneFixe = fixe;
		this.email = email;		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephoneMobile() {
		return telephoneMobile;
	}
	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}
	public String getTelephoneFixe() {
		return telephoneFixe;
	}
	public void setTelephoneFixe(String teleponeFixe) {
		this.telephoneFixe = teleponeFixe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

	public void addMatiere(Matiere m){
		matieres.add(m);
		m.addEnseignant(this);
	}
	

}
