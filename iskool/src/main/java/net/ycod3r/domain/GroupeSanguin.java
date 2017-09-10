package net.ycod3r.domain;

public enum GroupeSanguin {
	A_NEGATIF("A-"),A_POSITIF("A+"),B_NEGATIF("B-"),B_POSITIF("B+"),AB_NEGATIF("AB-"),AB_POSITIF("AB+"),O_NEGATIF("O-"),O_POSITIF("O+");
	
	private String groupe;
	
	private GroupeSanguin(String groupe){
		this.groupe = groupe;
	}
	
	public String getGroupe(){
		return this.groupe;
	}
}
