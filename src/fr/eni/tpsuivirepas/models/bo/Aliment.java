package fr.eni.tpsuivirepas.models.bo;

public class Aliment {

	private int id;
	private String nom;

	public Aliment(String nom) {
		this.nom = nom;

	}

	public Aliment(int id, String nom) {
		this.id = id;
		this.nom = nom;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
