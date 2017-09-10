package net.ycod3r.domain;

public enum Sexe {
	MASCULIN("Masculin"), FEMININ("Feminin");
	
	private String name;
	
	private Sexe(String sexe){
		this.name = sexe;
	}
	
	public String getName(){
		return this.name;
	}

}
