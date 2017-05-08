package net.ycod3r.domain;


public class Moyenne {
	
	private Eleve eleve;
	private Double moyenne;
	
	
	public Moyenne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Moyenne(Eleve eleve, Double moyenne) {
		super();
		this.eleve = eleve;
		this.moyenne = moyenne;
	}


	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Double getMoyenne() {
		return this.moyenne;
	}
	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}


	

}
