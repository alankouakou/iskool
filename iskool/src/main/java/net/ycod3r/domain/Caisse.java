package net.ycod3r.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caisse {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libelle;
	private Date dateMaj;
	private Long SoldeInitial;
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
	public Date getDateMaj() {
		return dateMaj;
	}
	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}
	public Long getSoldeInitial() {
		return SoldeInitial;
	}
	public void setSoldeInitial(Long soldeInitial) {
		SoldeInitial = soldeInitial;
	}

}
