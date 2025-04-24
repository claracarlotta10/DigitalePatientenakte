package de.digitale.patientenakte;

import java.util.List;
import java.util.Scanner;

public class TerminSteuerung {

	//legt auf basis von nutzereingabe einen termin an
	public static Termin terminAnlegen(Scanner scanner, List<Arzt> aerzte) {

		// Dem Nutzer die Ärtze aufzeigen mit Hilfe der Methode arztInfosAusgeben
		System.out.println("Übersicht der erfassten Ärzte: ");
		ArztSteuerung.arztInfosAusgeben(aerzte);

		// Nutzerinput einlesen für Arztname und Datum
		System.out.println("Nachname des Arztes, bei dem ein Termin angelegt werden soll:");
		String inputBehandelnderArzt = scanner.nextLine();
		Arzt behandelnderArzt = new Arzt();

		// Arzt in Liste von aertzen finden
		for (Arzt a : aerzte) {
			if (a.getNachname().equalsIgnoreCase(inputBehandelnderArzt)) {
				behandelnderArzt = a;
				break;
			} else {
				System.out.println("Dieser Arzt wurde nicht erfasst, deshlab kann bei ihm kein Termin angelegt werden");
			}
		}

		System.out.println("Datum des Termins im Format dd.mm.yyyy:");
		String inputDatum = scanner.nextLine();

		Termin neuerTermin = new Termin(behandelnderArzt, inputDatum);
		System.out.println(neuerTermin.getId());

		return neuerTermin;

	}

	// Gibt Vorname, Nachname und Fachrichtung aller erfassten Termine auf der
	// Konsole aus
	public static void terminInfosAusgeben(List<Termin> termine) {
		if (termine.isEmpty() || termine == null) {
			System.out.println("Es wurden noch keine Termine erfasst.");
		}
		for (Termin termin : termine) {
			System.out.println("BehandelnderArzt: " + termin.getBehandelnderArztName());
			System.out.println("Datum: " + termin.getDatum());
			System.out.println("Termin ID: " + termin.getId());
			System.out.println("-----------");
		}
	}

	//löscht einen termin aus einer liste von terminen anhand der Nutzereingabe der termin-ID
	public static void terminLoeschen(Scanner scanner, List<Termin> termine) {

		// Termin-ID erfassen
		System.out.println("Id des Termins der gelöscht werden soll?");
		int zuloeschenderTerminID = scanner.nextInt();
		scanner.nextLine(); // Sprung in nächste zeile nach nextInt()

		// Termin aus Terminliste zuordnen zu zu löschender ID
		Termin zuloeschenderTermin = null;
		for (Termin t : termine) {
			if (zuloeschenderTerminID == t.getId()) {
				zuloeschenderTermin = t;
			}
		}

		// Termin entfernen
		if (zuloeschenderTermin == null) {
			System.out.println("Der Termin ist nicht in der Liste");
		} else {
			termine.remove(zuloeschenderTermin);
			System.out.println("Termin gelöscht");

		}

	}
}
