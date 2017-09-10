package net.ycod3r.domain;

public enum Civilite {
	MONSIEUR("Monsieur","M"),MADAME("Madame","Mme"),MADEMOISELLE("Mademoiselle","Mlle");
	
	private String name;
	private String abbreviation;
	private Civilite(String name, String abbr){
		this.name = name;
		this.abbreviation = abbr;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}

}
