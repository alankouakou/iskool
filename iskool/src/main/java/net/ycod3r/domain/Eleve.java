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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Eleve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String matricule;
	@Size(min=2, message="Longueur minimum : 2")
	private String nom;
	@Size(min=3, message="Longueur minimum : 3")
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@NotNull @Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateNaissance;
	private String lieuNaissance;
	private String adresse;
	private String telephoneFixe;
	private String telephoneMobile;
	@Enumerated(EnumType.STRING)
	private GroupeSanguin groupeSanguin;
	@ManyToOne
	private Tuteur tuteur;
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	@Enumerated(EnumType.STRING)
	private SituationFamiliale situationFamiliale;
	private String boitePostale;
	private String email;
	private String titreAdmission;
	private String lieuObtention;
	private String etablissementOrigine;
	private int anneeObtention;
	private Boolean boursier;
	private String nomContactUrgence1;
	private String telephoneContactUrgence1;
	private Date dateEntree;
	private Date dateSortie;
	@ManyToOne
	private Niveau niveauScolaire;
	
	@ManyToOne
	private Classe classe;
	
	@OneToMany(mappedBy="eleve")
	Set<Note> notes = new HashSet<Note>();
	
	public Eleve(){}
	
	public Eleve(String nom, String prenom, Civilite civilite, Date dateNaissance, Classe classe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
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
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public Niveau getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(Niveau niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public GroupeSanguin getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(GroupeSanguin groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public Tuteur getTuteur() {
		return tuteur;
	}

	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public SituationFamiliale getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public String getBoitePostale() {
		return boitePostale;
	}

	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitreAdmission() {
		return titreAdmission;
	}

	public void setTitreAdmission(String titreAdmission) {
		this.titreAdmission = titreAdmission;
	}

	public String getLieuObtention() {
		return lieuObtention;
	}

	public void setLieuObtention(String lieuObtention) {
		this.lieuObtention = lieuObtention;
	}

	public String getEtablissementOrigine() {
		return etablissementOrigine;
	}

	public void setEtablissementOrigine(String etablissementOrigine) {
		this.etablissementOrigine = etablissementOrigine;
	}

	public int getAnneeObtention() {
		return anneeObtention;
	}

	public void setAnneeObtention(int anneeObtention) {
		this.anneeObtention = anneeObtention;
	}

	public Boolean getBoursier() {
		return boursier;
	}

	public void setBoursier(Boolean boursier) {
		this.boursier = boursier;
	}

	public String getNomContactUrgence1() {
		return nomContactUrgence1;
	}

	public void setNomContactUrgence1(String nomContactUrgence1) {
		this.nomContactUrgence1 = nomContactUrgence1;
	}

	public String getTelephoneContactUrgence1() {
		return telephoneContactUrgence1;
	}

	public void setTelephoneContactUrgence1(String telephoneContactUrgence1) {
		this.telephoneContactUrgence1 = telephoneContactUrgence1;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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
