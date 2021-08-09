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
	<title>Ajout d'un repas</title>
	</head>
	<body>
	<c:if test="${not empty requestScope.e}">
	 <p> erreur : ${e.getMessage()}</p>
	</c:if>
		<h1>Ajout</h1>
		<div class="formulaire">
		<form action="${pageContext.request.contextPath}/ajout" method="post">
		<div>
			<label for="date">Date :</label>
			<input type="date" id="date" name="date" value="25/05/2021" min="2021-05-01" max="2021-07-01" required>
		</div>
		<div>
		<label for="heure">Heure :</label>
			<input type="time" id="heure" name="heure" required>
		</div>		
		<div>
			<label for="repas">Repas :</label>
			<input class=repas type="text" id="aliments" name="aliments" size="50" height="300" maxlength="1000" placeholder="carottes, tomates, pâtes, saumon, fruits, yaourt...">
		</div>
		<input type="submit" value="valider">  	
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/accueil'" value="annuler">
		</form>	
		</div>

	</body>
</html>