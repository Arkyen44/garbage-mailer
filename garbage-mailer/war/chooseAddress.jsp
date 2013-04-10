<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.Data"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Garbage Mailer</title>
		<style type="text/css">
			<%@ include file="css/style.css" %>
		</style>
	</head>

	<body>

	<%
	//On récupère le user.
	UserService userService = UserServiceFactory.getUserService();
	User userGoogle = userService.getCurrentUser();
	%>

	<div id="menu-wrapper">
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="index.jsp">Homepage</a></li>
				<li><a href="apropos.jsp">A propos</a></li>

				<%
				//S'il est loggué
				if (userGoogle != null) {%>
					<li class="connexion"><a href="<%=userService.createLogoutURL(request.getRequestURI())%>">Deconnexion</a></li>
				<%}
				else{ %>
					<li class="connexion"><a href="<%=userService.createLoginURL(request.getRequestURI())%>">Connexion</a></li>
				<%} %>		
			</ul>
		</div>
	<!-- end #menu --> 
	</div>

	<div id="banner">
		<center>
		<img src="css/images/poubelles.jpg"  height="300" alt="" />
		</center>
	</div>

		<div id="header-wrapper">
			<div id="header">
				<div id="logo">
					<h1>Garbage<span>Mailer</span></h1>
					<p>Le ramasseur de poubelle</p>
				</div>
			</div>
		</div>
		<div id="wrapper"> 
		<!-- end #header -->

			<div id="page">
				<div id="page-bgtop">
					<div id="page-bgbtm">
						<div id="sidebar">
							<ul>
								<li>
									<h2>Search Here</h2>
									<div id="search" >
										<form method="get" action="#">
											<div>
												<input type="text" name="s" id="search-text" value="" />
												<input type="submit" id="search-submit" value="" />
											</div>
										</form>
									</div>
									<div style="clear: both;">&nbsp;</div>
								</li>
								<li>
									<h2>Garbage Mailer</h2>
									<p>L'application qui va changer votre tri</p>
								</li>
								<li>
									<h2>Categories</h2>
									<ul>
										<li>Poubelle jaune</li>
										<li>Poubelle bleue</li>
										<li>Tri'sac</li>
									</ul>
								</li>
							</ul>
						</div>
						<!-- end #sidebar -->	

					<div id="content">
					<div class="post">						

	<%
	//S'il est loggué
	if (userGoogle != null) {
		ArrayList<Data> dataToChoose = ((ArrayList<Data>)request.getAttribute("liste"));
	
	//on place dans la session la liste des datas
	//on pourra ainsi récupérer l'objet data qui convient grâce au rivolli transmis dans le formulaire ci-dessous
	HttpSession sess=request.getSession(true);
	sess.setAttribute("listeData", dataToChoose);
	if (dataToChoose!=null && dataToChoose.size()>0){
		%>
		
		<h2 class="littletitle">Choisissez votre rue</h2>						
						<div class="entry">
							<p>
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
		<p class="links"><input class="button" type="submit" value="Valider mes informations" /></p>
		</form>
		<%
	}else {
		%>
			<div style="clear: both;">&nbsp;</div>
			<p>Aucune adresse n'a été trouvée...</p>
			<br/>
			<p class="links"><a href="index.jsp" class="button">Retour</a></p>
		<%
	}%>

									</p>
						</div>
					</div>					

					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->

		<%
		//si l'utilisateur n'est pas loggué
	} 
	else {
		response.sendRedirect("index.jsp");
	}//fin if loggué else
	%>

				<div style="clear: both;">&nbsp;</div>
			</div>

		</div>

	</div>

	<!-- end #page --> 

</div>

<div id="footer">

	<p>&copy; 2013 Nicolas Dufour | Justine Bonnet | Cécile Rousseau | Vincent Bruneau </p>

</div>

<!-- end #footer -->

	

</body>

</html>