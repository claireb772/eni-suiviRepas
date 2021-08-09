<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<title>Accueil</title>
	</head>
	<body>
		<h1>ACCUEIL</h1>
			<div class=zonebouton>
				<div class=bouton_accueil>
					<a href="${pageContext.request.contextPath}/ajout">Ajouter un nouveau repas</a>
				</div>
				<div class=bouton_accueil>
					<a href="${pageContext.request.contextPath}/historique">Visualiser les repas</a>
				</div>
			</div>
	</body>
</html>