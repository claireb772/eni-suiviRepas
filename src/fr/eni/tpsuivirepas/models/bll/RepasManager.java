package fr.eni.tpsuivirepas.models.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpsuivirepas.dal.jdbc.RepasDAOJdbcImpl;
import fr.eni.tpsuivirepas.models.bo.Aliment;
import fr.eni.tpsuivirepas.models.bo.Repas;

public class RepasManager {

	// volonté de n'avoir qu'une seule instance de repasManager

	private RepasDAOJdbcImpl repasDAO = new RepasDAOJdbcImpl();

	public void ajouterRepas(LocalDate date, LocalTime heure, List<String> aliments) {

		List<Aliment> alimentsList = new ArrayList<Aliment>();
		for (String aliment : aliments) {
			alimentsList.add(new Aliment(aliment));
		}

		// déléguer à la DAL l'accès à la source de données
		Repas repas = new Repas(date, heure, alimentsList);

		try {
			repasDAO.insert(repas);
		} catch (Exception e) {
			// TODO MESSAGE D'ERREUR PERSO
			e.printStackTrace();
		}

	}

	public List<Repas> listerRepas() throws Exception {
		List<Repas> repas = repasDAO.selectAll();
		return repas;
	}
}
