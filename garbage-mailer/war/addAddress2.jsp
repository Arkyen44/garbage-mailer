<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.AddressBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("Dans adresse2"); 
//System.out.println(request.getAttribute("liste"));
List<AddressBean> liste = (List<AddressBean>) request.getAttribute("liste");
if (liste!=null){
	%>
	<form action="/addAddress" method="post">
	<select name="ListeRue"> <%
	for (AddressBean a : liste){
		%>
		<option value="<%= a.getRivolli() %>"><%= a.getNomRue() %></option>
		
		<br />
		<% 
	}
	%>
	<select/>
	<div><input type="submit" value="Valider mes informations" /></div>
	</form>
	<%
}

%>
</body>
</html>