package fr.eni.tpsuivirepas.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpsuivirepas.models.bll.RepasManager;

/**
 * Servlet implementation class AjouterRepasServlet
 */
@WebServlet("/ajout")
public class AjouterRepasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// stocke la référence aux managers

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterRepasServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(request.getParameter("date"), dtf);

			DateTimeFormatter dtfh = DateTimeFormatter.ofPattern("HH:mm");
			LocalTime heure = LocalTime.parse(request.getParameter("heure"), dtfh);

			String aliments = request.getParameter("aliments");
			String[] alimentNom = aliments.split(",");

			RepasManager mgr = new RepasManager();

			mgr.ajouterRepas(localDate, heure, Arrays.asList(alimentNom));

			RequestDispatcher rd = request.getRequestDispatcher("/historique");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erreur", e);
			doGet(request, response);
		}

	}

}
