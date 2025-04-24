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

		/*
		 * Überprüfen ob Eingabe (inputFachrichtungString) mit einem Enum Wert bzw.
		 * desen BEschreibung übereinstimmt und entsprechend in Variable für Arztinstanz
		 * speichern (inputFachrichtungEnum)
		 */

		// TODO Exception geht nicht bzw Fall wird nicht aufegrufen --> weil davor null
		// gesetzt??
		// TODO evtl methode auslagern in ENUM-File? Geht das?
		// TODO Leerzecihen behandeln bei innerer medizin --> nextLine()
		// Problem: Wie enum initialisiern ohne null? --> sonst kein Zugriff darauf
		// außerhlab. Weiteres Problem damit: Arzt wird mit null angelegt, das führt bei
		// Option 2 dann zu Fehler
		// TODO: Rückfrage an PO, was bei ungültiger Einagbe passieren soll.
		// Zurückspringen ins Menü?
		Fachrichtungen inputFachrichtungEnum = null;

		for (Fachrichtungen f : Fachrichtungen.values()) {
			if (f.getBeschreibung().equalsIgnoreCase(inputFachrichtungString)) {// Groß und Kleinschreibung kann
																				// ignoeriert werden
				inputFachrichtungEnum = f;
				System.out.println("Test2" + f.getBeschreibung());
				break;
			}
		}
		if (inputFachrichtungEnum == null) {
			System.out
					.println("Diese Fachrichtung steht nicht zur Wahl. Wähle erneut im Menü aus, was du tun möchtest.");
			return null;
		}

		// Arztinstanz ausgeben mit den gespeicherten Inputwerten sofern input !=
		// null/gültig
		// if (inputFachrichtungEnum != null) {
		Arzt neuerArzt = new Arzt(inputVorname, inputNachname, inputFachrichtungEnum);
		System.out.println("Arzt für " + inputFachrichtungEnum.getBeschreibung() + " " + inputVorname + " "
				+ inputNachname + " wurde erfasst.");
		return neuerArzt;
		// } else {
		// return null;
		// }

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

	// TODO anpassen an Arzt
	// TODO check, if liste von terminen mit dem arzt ist empty
	// Überprüfung hier oder in Main?
	public static void arztLoeschen(Scanner scanner, List<Arzt> aerzte) {
		// Termin-ID erfassen
		System.out.println("Id des Termins der gelöscht werden soll?");
		String zuloeschenderArztName = scanner.nextLine();

		// Termin aus Terminliste zuordnen zu zu löschender ID
		Arzt zuloeschenderArzt = null;
		for (Arzt a : aerzte) {
			if (zuloeschenderArztName.equalsIgnoreCase(zuloeschenderArzt.getNachname())) {
				zuloeschenderArzt = a;
			}
		}
		// TODO check if termine ist empty
		// neuer übergebener parameter list termine
		// if list termine contains zuloeschenderArzt dann sysout termin kann nicht
		// gelöscht werden
		// schleife über termine und if check ob behand arzt equals zuloeschenderArzt
		// --> wenn ja, dann ausgabe dass nicht gelöscht werden kann
		//wenn nein dann else fall (aber außerhalb for schleife, weil der else fall sich aufs äßuere if bezieht

		// Termin entfernen
		if (zuloeschenderArzt == null) {
			System.out.println("Der Arzt ist nicht in der Liste");
		} else {
			aerzte.remove(zuloeschenderArzt);
			System.out.println("Termin gelöscht");

		}
	}
	// TODO entfernen, war nur Test, ob Arzt und Termin in einer generischen Methode
	// funktionieren
	/*
	 * public void arztLoeschenGenerisch(Scanner scanner,List<T> liste) { //
	 * Termin-ID erfassen System.out.println("Id des T der gelöscht werden soll?");
	 * String zuloeschendesElementString = scanner.nextLine();
	 * 
	 * // Termin aus Terminliste zuordnen zu zu löschender ID T zuloeschendesElement
	 * = null; for (T t : liste) { if
	 * (zuloeschendesElementString.equalsIgnoreCase(zuloeschendesElement.getNachname
	 * ())) { zuloeschendesElement = t; } }
	 * 
	 * // Termin entfernen if (zuloeschendesElement == null) {
	 * System.out.println("Der Termin ist nicht in der Liste"); } else {
	 * liste.remove(zuloeschendesElement); System.out.println("Termin gelöscht");
	 * 
	 * } }
	 */
}
