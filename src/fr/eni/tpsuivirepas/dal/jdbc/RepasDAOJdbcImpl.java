package fr.eni.tpsuivirepas.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpsuivirepas.dal.RepasDAO;
import fr.eni.tpsuivirepas.models.bo.Aliment;
import fr.eni.tpsuivirepas.models.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {

	private static final String INSERT = "insert into REPAS(date_repas, heure_repas) values (?,?)";
	private static final String INSERTALIMENT = "insert into Aliments(nom, id_repas) values (?,?)";
	private static final String SELECT = "select repas.id, date_repas, heure_repas, aliments.id as id_aliment, nom from repas inner join ALIMENTS on repas.id = ALIMENTS.id_repas order by date_repas desc, heure_repas desc";

	@Override
	public Repas insert(Repas repas) throws Exception {
		// modification du LocalDate et LocalTime en SQL date et time avant insertion en
		// BDD

		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false);
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, java.sql.Date.valueOf(repas.getDate_repas()));
			pstmt.setTime(2, java.sql.Time.valueOf(repas.getHeure_repas()));
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				repas.setId(rs.getInt(1));
			}

			for (Aliment aliment : repas.getAliment()) {
				PreparedStatement rqtAliment = cnx.prepareStatement(INSERTALIMENT,
						PreparedStatement.RETURN_GENERATED_KEYS);
				rqtAliment.setString(1, aliment.getNom());
				rqtAliment.setInt(2, repas.getId());
				rqtAliment.executeUpdate();
				ResultSet rsAliment = rqtAliment.getGeneratedKeys();
				if (rsAliment.next()) {
					aliment.setId(rsAliment.getInt(1));
				}
			}
			cnx.commit();
		} catch (SQLException e) {
			cnx.rollback();
			throw new Exception("Problème lors de l'ajout de l'avis. [" + e.getMessage() + "]");

		}
		return repas;
	}

	@Override
	public List<Repas> selectAll() throws Exception {
		List<Repas> lesRepas = new ArrayList<Repas>();
		try (Connection cnx = ConnectionProvider.getConnection(); Statement rqt = cnx.createStatement();) {
			ResultSet rs = rqt.executeQuery(SELECT);

			int idCurrentRepas = 0;
			Repas repasCourant = null;

			while (rs.next()) {

				if (idCurrentRepas != rs.getInt("id")) {

					repasCourant = new Repas();
					repasCourant.setId(rs.getInt("id"));
					repasCourant.setDate_repas(rs.getDate("date_repas").toLocalDate());
					repasCourant.setHeure_repas(rs.getTime("heure_repas").toLocalTime());
					idCurrentRepas = rs.getInt("id");
					// associer le 1er aliment à ce repas
					Aliment aliment = new Aliment(rs.getInt("id_aliment"), rs.getString("nom"));
					repasCourant.getAliment().add(aliment);
					lesRepas.add(repasCourant);

				} else {
					Aliment aliment = new Aliment(rs.getInt("id_aliment"), rs.getString("nom"));
					repasCourant.getAliment().add(aliment);

				}
			}
		} catch (SQLException e) {
			// propager une exception personnalisée
			throw new Exception("Problème d'extraction des repas de la base. Cause : " + e.getMessage());
		}
		return lesRepas;
	}
}