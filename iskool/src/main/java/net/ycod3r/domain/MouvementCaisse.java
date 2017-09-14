package net.ycod3r.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MVT_CAISSE")
public class MouvementCaisse {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private TypeMouvement typeMvt;
	private Date dateMvt;
	private Long montantMvt;
	private Date dateDerniereMaj;
	@ManyToOne
	private Caisse caisse;
	private String user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeMouvement getTypeMvt() {
		return typeMvt;
	}
	public void setTypeMvt(TypeMouvement typeMvt) {
		this.typeMvt = typeMvt;
	}
	public Date getDateMvt() {
		return dateMvt;
	}
	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}
	public Long getMontantMvt() {
		return montantMvt;
	}
	public void setMontantMvt(Long montantMvt) {
		this.montantMvt = montantMvt;
	}
	public Date getDateDerniereMaj() {
		return dateDerniereMaj;
	}
	public void setDateDerniereMaj(Date dateDerniereMaj) {
		this.dateDerniereMaj = dateDerniereMaj;
	}
	public Caisse getCaisse() {
		return caisse;
	}
	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
