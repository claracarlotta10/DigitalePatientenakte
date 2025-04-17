package de.digitale.patientenakte;

import java.util.List;
import java.util.Scanner;

public class Arzt {
	
	private String vorname; 
	private String nachname; 
	private String fachgebiet;
	
	public Arzt(String vorname, String nachname, String fachgebiet){
		this.vorname = vorname;
		this.nachname = nachname;
		this.fachgebiet = fachgebiet;
	}
	
	public Arzt arztAnlegen2(Scanner scanner) {
		String inputVorname = scanner.nextLine();
		System.out.println("Vorname:");

		String inputNachname = scanner.nextLine();
		System.out.println("Nachname:");

		String inputFAchrichtung = scanner.nextLine();
		System.out.println("Fachrichtung");
		Arzt neuerArzt = new Arzt(inputVorname, inputNachname, inputFAchrichtung);
		return neuerArzt;
	}
	
	public void arztInfosAusgeben2(List<Arzt> ärzte) {
		if (ärzte.isEmpty()) {
			System.out.println("Es wurden noch keine Ärzte erfasst.");
		}
		for (Arzt arzt : ärzte) {
			// TODO nachfragen, ob hier etwas ausgegeben werden soll
			// System.out.println("Arzt nr ");
			System.out.println(arzt.getVorname());
			System.out.println(arzt.getNachname());
			System.out.println(arzt.getFachgebiet());
		}
	}
	
	
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getFachgebiet() {
		return fachgebiet;
	}

	public void setFachgebiet(String fachgebiet) {
		this.fachgebiet = fachgebiet;
	}

	public String getVorname() {
		return vorname;
	}
	

}
