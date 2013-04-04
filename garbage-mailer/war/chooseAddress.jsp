<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.Data"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//On récupère le user.
UserService userService = UserServiceFactory.getUserService();
User userGoogle = userService.getCurrentUser();
//S'il est loggué
if (userGoogle != null){
	ArrayList<Data> dataToChoose = ((ArrayList<Data>)request.getAttribute("liste"));
	
	//on place dans la session la liste des data
	//on pourra ainsi récupérer l'objet data qui convient grâce au rivolli transmis dans le formulaire ci-dessous
	 HttpSession sess=request.getSession(true);
	sess.setAttribute("listeData", dataToChoose);
	if (dataToChoose!=null && dataToChoose.size()>0){
		%>
		<form action="/addAddress" method="post">
		<%
		for (Data d : dataToChoose){
			%>
			<input name="choixAdresse" type="radio" value="<%= d.getRivoli() %>"><%= d.getLibelle() %></option>
			<br />
			<% 
		}
		%>
		<input name="numRue" type="hidden" value="<%= request.getAttribute("num") %>" />
		<div><input type="submit" value="Valider mes informations" /></div>
		</form>
		<%
	}else {
		%>
			<p>Aucune adresse n'a été trouvées...</p>
			<br/>
			<a href="index.jsp">Retour</a>
		<%
	}

}else{
	%>
		<h1>Bienvenue dans le Garbage Mailer!</h1>
	<p>Cet outil révolutionnaire vous permettra d'être averti du jour de ramassage de vos poubelle...
	Pour cela? Rien de plus simple : <br />
		1 - Se connecter <br />
		2 - Renseigner son adresse <br />
		3 - Etre averti en temps voulu du passage du camion poubelle <br />
	</p>
	
	<h2>Connexion : </h2><a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Ici</a>
	
	<%
	}//fin if loggué else
	%>
	
	
</body>
</html>