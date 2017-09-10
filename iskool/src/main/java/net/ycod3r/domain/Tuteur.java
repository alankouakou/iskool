package net.ycod3r.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tuteur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	private String typeTuteur;
	@Enumerated(EnumType.STRING)
	private Civilite civilité;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephoneMobile;
	private String teleponeFixe;
	private String email;
	private String profession;
	public String getTypeTuteur() {
		return typeTuteur;
	}
	public void setTypeTuteur(String typeTuteur) {
		this.typeTuteur = typeTuteur;
	}
	public Civilite getCivilité() {
		return civilité;
	}
	public void setCivilité(Civilite civilité) {
		this.civilité = civilité;
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
	public String getTeleponeFixe() {
		return teleponeFixe;
	}
	public void setTeleponeFixe(String teleponeFixe) {
		this.teleponeFixe = teleponeFixe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	

}
