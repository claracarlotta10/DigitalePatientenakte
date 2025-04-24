package de.digitale.patientenakte;

public enum Fachrichtungen {
	KARDIOLOGIE("Kardiologie"),  UROLOGIE("Urologie"), INNERE_MEDIZIN("Innere Medizin"), KINDERARZT("Kinderarzt");
	
	private String beschreibung;
	
	private Fachrichtungen(String beschreibung){
		this.beschreibung = beschreibung;
	}
	
	//per Getter BEschreibung aufrufen als klein geschriebene Version
	public String getBeschreibung() {
		return beschreibung;
	}

	
}
