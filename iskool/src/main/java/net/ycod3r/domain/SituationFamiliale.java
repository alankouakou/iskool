package net.ycod3r.domain;

public enum SituationFamiliale {
	CELIBATAIRE("Célibataire"), MARIE("Marié(e)"), DIVORCE("Divorcé(e)"), VEUF("Veuf(ve)");
	
	private String name; 
	private SituationFamiliale(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
