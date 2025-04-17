package de.digitale.patientenakte;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PatientenAktenApplikation {

	// Hilfsmethode
	// TODO evtl besser in Arztklasse auslagern?
	public static Arzt arztAnlegen(Scanner scanner) {
		String inputVorname = scanner.nextLine();
		System.out.println("Vorname:");

		String inputNachname = scanner.nextLine();
		System.out.println("Nachname:");

		String inputFAchrichtung = scanner.nextLine();
		System.out.println("Fachrichtung");
		Arzt neuerArzt = new Arzt(inputVorname, inputNachname, inputFAchrichtung);
		System.out.println(neuerArzt.getVorname() + neuerArzt.getNachname() + " wurde hinzugefügt.");

		return neuerArzt;
	}
	
	
	public static void arztInfosAusgeben(List<Arzt> ärzte) {
		if (ärzte.isEmpty()) {
			System.out.println("Es wurden noch keine Ärzte erfasst.");
		}
		for (Arzt arzt : ärzte) {
			//TODO nachfragen, ob hier etwas ausgegeben werden soll
			//System.out.println("Arzt nr ");
			System.out.println(arzt.getVorname());
			System.out.println(arzt.getNachname());
			System.out.println(arzt.getFachgebiet());
		}
	}

	public static void main(String[] args) {

		// Variablen und Objektinstanzen Deklarierung / INitialisierung
		List<Arzt> ärzte = new ArrayList<Arzt>();

		Scanner scanner = new Scanner(System.in);
		boolean programmBeenden = false; // zur Nutzung als Abbruchbedingung in der while Schleife
		// boolean arztVollständig = false; // Zur Nutzung abbruchbedingung while
		// Schelife in Case 1

		// Dialog-Logik
		System.out
				.println("Willkommen zu deiner digitalen Patientenakte. Wähle aus, was du als nächstes tun möchtest:");

		// solange programmBeenden false führe Schleife aus
		while (!programmBeenden) {

			System.out.println("Menü");
			System.out.println("Option 1: 'Arzt erfassen'");
			System.out.println("Option 2: 'Ärzteliste anzeigen'");
			System.out.println("Option 3: 'Programm beenden'.");
			System.out.println("Gib 1, 2 oder 3 ein:");

			// Eingabe des Nutzers
			int inputZahl = 0;
			try {
				inputZahl = scanner.nextInt();

			} catch (InputMismatchException e) {
				inputZahl = -1;
				scanner.nextLine();// notwendig zur Fehlerbehandlung von nextInt, da sonst endlos schleife
									// (Irgendwas mit Puffer leeren)
			}

			// Switch Case auf Basis von Nutzeriengabe (inputZahl). 1,2,3 gültig, default
			// erneut aufrufen
			switch (inputZahl) {
			case 1:
				// TODO Arztinfos eingeben durch Nutzer und damit Arztinstanz erstellen. Diese
				// dann hinzufügen zu ärzte Liste
				// Idee: 3 input-Strings speichern durch scanner.next(Line) und diese dann als
				// Variablen setzen für die Arztinstanz
				// also zB Arzt arzt1 = new Arzt(input1, inpu2, input3);
				// dann hinzufügen zu liste ärzte.add(arzt1);
				// TODO evtl Methode auslagern?
				// }
				/*
				 * String inputVorname = scanner.nextLine(); System.out.println("Vorname:");
				 * 
				 * String inputNachname = scanner.nextLine(); System.out.println("Nachname:");
				 * 
				 * String inputFAchrichtung = scanner.nextLine();
				 * System.out.println("Fachrichtung");
				 * 
				 * 
				 * Arzt neuerArzt = new Arzt(inputVorname, inputNachname, inputFAchrichtung);
				 */

				// Aufruf der Hilfsmethode arztAnlegen
				Arzt neuerArzt = arztAnlegen(scanner);

				// zu Liste ärzte den neuen Arzt hinzufügen
				ärzte.add(neuerArzt);

				break;
			case 2:
				System.out.println("Du hast Option 2 gewählt. Hier ist eine Übersicht aller erfassten Ärzte:");
				// Aufruf der Hilfsmethode arztInfosAusgeben mit der Liste ärzte, die in case1 befüllt wurde.
				arztInfosAusgeben(ärzte);



				break;

			case 3:
				System.out.println("Programm wurde beendet.");
				// Abbruchbedingung der Schleife
				programmBeenden = true;
				break;
			case -1:
				System.out.println("Ausgewählte Option ungültig.");
				break;

			default:
				System.out.println("Deine Eingabe war ungültig.");

			}

		}

	}

}
