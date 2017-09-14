package net.ycod3r.domain;

public enum StatutEvaluation {
	NOUVEAU("Nouveau","bg-aqua"),
	PLANIFIE("Planifié","bg-blue"),
	ANNULE("Annulé","bg-red"),
	REPORTE("Reporté","bg-orange"),
	TERMINE("Terminé","bg-green");
	
	private String name;
	private String cssClass;
	private StatutEvaluation(String name,String cssClass){
		this.name = name;
		this.cssClass = cssClass;
	}

	public String getName(){
		return name;
	}
	
	public String getCssClass(){
		return cssClass;
	}
}
