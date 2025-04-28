package de.digitale.patientenakte;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//hat keinen Status, bedient nur Funktionalität
public class ArztSteuerung<T, A> {

	// statische Hilfsmethoden

	// Methode um einen neuen Arzt anzulegen durch Nutzerinegabe in der Konsole
	public static Arzt arztAnlegen(Scanner scanner) {
		System.out.println("Vorname:");
		String inputVorname = scanner.nextLine();

		System.out.println("Nachname:");
		String inputNachname = scanner.nextLine();

		// Dem Nutzer die Fachrichtungen aufzeigen
		System.out.println(
				"Gib die Fachrichtung deines Artzes an indem du den entsprechenden Begriff eingibst. Du hast zur Auswahl: ");
		for (Fachrichtungen f : Fachrichtungen.values()) {
			System.out.println(f.getBeschreibung());
		}

		// Nutzereingabe der Fachrichtung als String
		String inputFachrichtungString = scanner.nextLine(); // ermöglicht auch Erfassung von zwei Wörtern durch
																// Verhalten von nextLine

		// Auf Basis der Nutzereingabe die entsprechende Fachrichtung oder null
		// ermitteln
		Fachrichtungen inputFachrichtungEnum = Fachrichtungen
				.findFachrichtungForMatchingInputString(inputFachrichtungString);

		if (inputFachrichtungEnum == null) {
			System.out
					.println("Diese Fachrichtung steht nicht zur Wahl. Wähle erneut im Menü aus, was du tun möchtest.");
			return null;
		}

		// Arzt anlegen auf BAsis des nutzer inputs
		Arzt neuerArzt = new Arzt(inputVorname, inputNachname, inputFachrichtungEnum);
		System.out.println("Arzt für " + inputFachrichtungEnum.getBeschreibung() + " " + inputVorname + " "
				+ inputNachname + " wurde erfasst.");
		return neuerArzt;

	}

	// Gibt Vorname, NAchname und Fachrichtung aller erfassten Ärzte auf der Konsole
	// aus
	public static void arztInfosAusgeben(List<Arzt> aerzte) {
		if (aerzte.isEmpty() || aerzte == null) {
			System.out.println("Es wurden noch keine Ärzte erfasst.");
		}
		for (Arzt arzt : aerzte) {
			System.out.println("Vorname: " + arzt.getVorname());
			System.out.println("Nachname: " + arzt.getNachname());
			System.out.println("Fachgebiet: " + arzt.getFachrichtung().getBeschreibung());
			System.out.println("-----------");
		}
	}

	public static void arztLoeschen(Scanner scanner, List<Arzt> aerzte, List<Termin> termine) {
		// Termin-ID erfassen
		System.out.println("Nachname des Arztes der gelöscht werden soll?");
		String zuloeschenderArztName = scanner.nextLine();

		// Termin aus Terminliste zuordnen zu zu löschender ID
		Arzt zuloeschenderArzt = null;
		for (Arzt arzt : aerzte) {
			if (zuloeschenderArztName.equalsIgnoreCase(arzt.getNachname())) {
				zuloeschenderArzt = arzt;
				// break;
			}
		}

		if (zuloeschenderArzt == null) {
			System.out.println("Der Arzt ist nicht in der Liste");
		} else {
			boolean arztHatTermin = false;
			for (Termin termin : termine) {
				if (termin.getBehandelnderArzt().equals(zuloeschenderArzt)) {
					System.out.println(
							"Arzt kann nicht entfernt werden, da noch Termine bei ihm vorliegen. Bitte zuerst unter Menüpunkt x den Termin entfernen.");
					arztHatTermin = true;
				}
			}
			// Termin entfernen
			if (!arztHatTermin) {
				aerzte.remove(zuloeschenderArzt);
				System.out.println("Arzt gelöscht");
			}
		}

	}

}
