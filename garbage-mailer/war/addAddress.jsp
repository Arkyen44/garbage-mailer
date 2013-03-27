<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une adresse</title>
</head>
<body>


<!-- on demande le quartier -->
<form action="/address" method="post">
	<p>-Choix du quartier dans Nantes</p>
	<select name="ListeQuartier">
	   	<option selected="selected" value="Centre Ville">Centre Ville</option>
	   	<option value="Bellevue - Chantenay - Sainte Anne">Bellevue - Chantenay - Sainte Anne</option>
	   	<option value="Dervallieres - Zola">Dervallières - Zola</option>
	   	<option value="Hauts Paves - Saint Felix">Hauts Pavés - Saint Félix</option>
	   	<option value="Malakoff - Saint-Donatien">Malakoff - Saint-Donatien</option>
	   	<option value="Ile de Nantes">Ile de Nantes</option>
	   	<option value="Breil - Barberie">Breil - Barberie</option>
	   	<option value="Nantes Nord">Nantes Nord</option>
	   	<option value="Nantes Erdre">Nantes Erdre</option>
	   	<option value="Doulon - Bottiere">Doulon - Bottière</option>
	   	<option value="Nantes Sud">Nantes Sud</option>
	</select>
	<p>-Choix du type de rue</p>
	<select name="ListeTypeRue">
	   	<option selected="selected" value="Allee">Allée</option>
		<option value="Avenue">Avenue</option>
		<option value="Boulevard">Boulevard</option>
		<option value="Chemin">Chemin</option>
		<option value="Cour">Cour</option>
		<option value="Cours">Cours</option>
		<option value="Esplanade">Esplanade</option>
		<option value="Impasse">Impasse</option>
		<option value="Jardin">Jardin</option>
		<option value="Passage">Passage</option>
		<option value="Place">Place</option>
		<option value="Pont">Pont</option>
		<option value="Quai">Quai</option>
		<option value="Route">Route</option>
		<option value="Rue">Rue</option>		
		<option value="Ruelle">Ruelle</option>
		<option value="Square">Square</option>
		<option value="Venelle">Venelle</option>
	</select>
	<div><input type="submit" value="Valider mes informations" /></div>
</form>


</body>
</html>