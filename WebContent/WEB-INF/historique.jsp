<%@page import="java.util.List" %>
<%@page import="fr.eni.tpsuivirepas.models.bo.Repas" %>
<%@page import= "fr.eni.tpsuivirepas.models.bo.Aliment" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<title>historique</title>
	</head>
	<body>
	<c:if test="${not empty requestScope.e}">
	 <p> erreur : ${e.getMessage()}</p>
	</c:if>
		<h1>Historique</h1>
		<div class=container>
			<div class="espaceRepas">
				<table>
				<thead>
						<tr>
							<th>Date</th>
							<th>Heure</th>
							<th>Aliments</th>
						</tr>
					</thead>
                   <c:if test="${not empty repas}">	
					<tbody>
					<c:forEach var="rep" items="${repas}">
					<tr>
						<td>${rep.date_repas}</td>
						<td>${rep.heure_repas}</td>					
								<td>
							<c:forEach var="aliment" items="${rep.aliment}">
								<ul>
									<li>${aliment.nom}</li>
								</ul>
							</c:forEach>
						</td>				
					</tr>
					</c:forEach>
					
					 </c:if>
					</tbody>
				</table>
				</div>
				<div class="zonebouton_historique">
					<div class="bouton_historique">
						<a href="${pageContext.request.contextPath}/ajout">Ajouter un nouveau repas</a>
					</div>	
					<div class="bouton_historique">			
						<a  href="${pageContext.request.contextPath}/accueil">Retour à l'accueil</a>
				</div>	
			</div>
		</div>	
	</body>
</html>