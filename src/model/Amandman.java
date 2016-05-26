package model;

public class Amandman {
	private Akt akt;
	private String izmjena;
	private String obrazlozenje;
	
	private User podnosilac;
	
	public Amandman(Akt akt, String izmjena, String obrazlozenje, User podnosilac) {
		super();
		this.akt = akt;
		this.izmjena = izmjena;
		this.obrazlozenje = obrazlozenje;
		this.podnosilac = podnosilac;
	}

	public User getPodnosilac() {
		return podnosilac;
	}

	public void setPodnosilac(User podnosilac) {
		this.podnosilac = podnosilac;
	}

	public Akt getAkt() {
		return akt;
	}

	public void setAkt(Akt akt) {
		this.akt = akt;
	}

	public String getIzmjena() {
		return izmjena;
	}

	public void setIzmjena(String izmjena) {
		this.izmjena = izmjena;
	}

	public String getObrazlozenje() {
		return obrazlozenje;
	}

	public void setObrazlozenje(String obrazlozenje) {
		this.obrazlozenje = obrazlozenje;
	}
	
	
}
