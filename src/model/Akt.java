package model;

public class Akt {

	private String naziv;
	private String datum;

	public Akt(String naziv, String datumDonosenja) {
		super();
		this.naziv = naziv;
		this.datum = datumDonosenja;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
