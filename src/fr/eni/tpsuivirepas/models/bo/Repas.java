package fr.eni.tpsuivirepas.models.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {

	private int id;
	private LocalDate date_repas;
	private LocalTime heure_repas;
	private List<Aliment> aliment;

	public Repas() {
		this.aliment = new ArrayList<Aliment>();

	}

	public Repas(int id, LocalDate date_repas, LocalTime heure_repas) {
		this.id = id;
		this.date_repas = date_repas;
		this.heure_repas = heure_repas;

	}

	public Repas(LocalDate date_repas, LocalTime heure_repas, List<Aliment> aliments) {
		super();
		this.date_repas = date_repas;
		this.heure_repas = heure_repas;
		this.aliment = aliments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_repas() {
		return date_repas;
	}

	public void setDate_repas(LocalDate date_repas) {
		this.date_repas = date_repas;
	}

	public LocalTime getHeure_repas() {
		return heure_repas;
	}

	public void setHeure_repas(LocalTime heure_repas) {
		this.heure_repas = heure_repas;
	}

	public List<Aliment> getAliment() {
		return aliment;
	}

}
