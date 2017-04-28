package net.ycod3r.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeNote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private double ponderation;
	
	public TypeNote(){}

	public TypeNote(String name, double ponderation) {
		super();
		this.name = name;
		this.ponderation = ponderation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPonderation() {
		return ponderation;
	}

	public void setPonderation(double ponderation) {
		this.ponderation = ponderation;
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
