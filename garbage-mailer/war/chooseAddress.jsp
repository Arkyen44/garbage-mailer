<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.Data"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

ArrayList<Data> dataToChoose = ((ArrayList<Data>)request.getAttribute("liste"));

//on place dans la session la liste des data
//on pourra ainsi récupérer l'objet data qui convient grâce au rivolli transmis dans le formulaire ci-dessous
 HttpSession sess=request.getSession(true);
sess.setAttribute("listeData", dataToChoose);
if (dataToChoose!=null){
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
	<div><input type="submit" value="Valider mes informations" /></div>
	</form>
	<%
}

%>
</body>
</html>