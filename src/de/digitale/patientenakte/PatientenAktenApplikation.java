package de.digitale.patientenakte;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PatientenAktenApplikation {

	public static void main(String[] args) {

		// Variablen und Objektinstanzen Deklarierung / INitialisierung
		List<Arzt> aerzte = new ArrayList<Arzt>();
		List<Termin> termine = new ArrayList<Termin>();

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
			System.out.println("Option 3: 'Termin anlegen'");
			System.out.println("Option 4: 'Termine anzeigen'");
			System.out.println("Option 5: 'Termin löschen'.");
			System.out.println("Option 6: 'Programm beenden'.");
			System.out.println("Gib 1, 2, 3, 4, 5,6 oder 7 ein:");

			// Eingabe des Nutzers
			int inputZahl = 0;
			try {
				inputZahl = scanner.nextInt();
				scanner.nextLine();

			} catch (InputMismatchException e) {
				inputZahl = -1;
				scanner.nextLine();// notwendig zur Fehlerbehandlung von nextInt, da sonst endlos schleife
									// (Irgendwas mit Puffer leeren)
			}

			// Switch Case auf Basis von Nutzeriengabe (inputZahl). bei default erneut
			// aufrufen
			switch (inputZahl) {
			case 1:

				// Aufruf der Hilfsmethode arztAnlegen
				Arzt neuerArzt = ArztSteuerung.arztAnlegen(scanner);

				// zu Liste ärzte den neuen Arzt hinzufügen
				// TODO evtl hier abfragen ob neuerArzt != null?
				aerzte.add(neuerArzt);

				break;
			case 2:
				System.out.println("Du hast Option 2 gewählt. Hier ist eine Übersicht aller erfassten Ärzte:");
				// Aufruf der Hilfsmethode arztInfosAusgeben mit der Liste ärzte, die in case1
				// befüllt wurde.
				ArztSteuerung.arztInfosAusgeben(aerzte);

				break;
			case 3:
				System.out.println("Du hast die Option Termin anlegen gewählt.");
				// Einen Arzt aus der Liste von Ärzten auswählen
				// D.h. Liste darstellen von Ärzten und dann einen auswählen per Name oder so?
				// Terminklasse anlegen mit notwendigen Attributen
				// am Ende soll neue Termininstanz returned werden?
				Termin neuerTermin = TerminSteuerung.terminAnlegen(scanner, aerzte);
				termine.add(neuerTermin);
				break;
			case 4:
				System.out.println("Hier ist eine Übersicht aller erfassten Termine:");
				// Aufruf der Hilfsmethode arztInfosAusgeben mit der termine
				TerminSteuerung.terminInfosAusgeben(termine);
				break;
			case 5:
				TerminSteuerung.terminLoeschen(scanner, termine);
				System.out.println("Termin wurde gelöscht.");
				break;
			case 6:
				ArztSteuerung.arztLoeschen(scanner, aerzte);
				break;
			case 7:
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
