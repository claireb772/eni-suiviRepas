package fr.eni.tpsuivirepas.dal;

import java.util.List;

import fr.eni.tpsuivirepas.models.bo.Repas;

public interface RepasDAO {

	Repas insert(Repas repas) throws Exception;

	List<Repas> selectAll() throws Exception;

}
