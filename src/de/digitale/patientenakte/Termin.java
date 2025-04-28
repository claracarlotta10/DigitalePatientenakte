package de.digitale.patientenakte;

public class Termin {

	private Arzt behandelnderArzt;
	private String datum;
	private int id;

	static int idCounter = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Arzt getBehandelnderArzt() {
		return behandelnderArzt;
	}

	public void setBehandelnderArzt(Arzt behandelnderArzt) {
		this.behandelnderArzt = behandelnderArzt;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Termin(Arzt behandelnderArzt, String datum) {
		this.behandelnderArzt = behandelnderArzt;
		this.datum = datum;
		this.id = ++idCounter;
	}

	public Termin() {
		this.id = ++idCounter;
		// TODO Auto-generated constructor stub
	}

}
