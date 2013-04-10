<%@page import="classes.Requete"%>
<%@page import="beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

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
				<li><a href="aPropos.jsp">A propos</a></li>

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
		<img src="css/images/poubelles.jpg"  height="300" alt="image poubelles" />
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
									<h2>Garbage Mailer</h2>
									<p>L'application qui va changer votre tri</p>
								</li>
								<li>
									<h2>Categories</h2>
									<ul>
										<li>Poubelle jaune</li>
										<li>Poubelle bleue</li>
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
							%>	
						
								<h2 class="title">Bonjour, <span><%=userGoogle.getNickname()%></span></h2>	
								<div style="clear: both;">&nbsp;</div>					
								<div class="entry">
								
									<%
									//on récupère le user en BDD
									List<UserBean> listeUb = Requete.getUser(userGoogle.getEmail());
									//si la liste n'est pas vide, on affiche les adresses
									if (listeUb != null) {
									%>
										<TABLE>
											<p>Vous trouverez ci-dessous le récapitulatif de vos adresses ainsi que le jour de ramassage de vos poubelles.</p>
											
											<TR>
												<TH>Numéro<hr/></TH>
												<TH class="titre">Rue<hr/></TH>
												<TH>Bleue<hr/></TH>
												<TH>Jaune<hr/></TH>
												<TH></TH>
											</TR>
											<%
											for (UserBean ub : listeUb) {
											%>
												<TR>
													<TH><%=ub.getNumero()%></TH>
													<TH><%=ub.getAddress()%></TH>
													<TH><%=ub.getBleu()%></TH>
													<TH><%=ub.getJaune()%></TH>
													<TH><a href="/delAddress?idDel=<%=ub.getRivolli()%>">Supprimer l'adresse</a></TH>
												</TR>
										<%
											}
										%>
										</TABLE>
									
									<%
									} 
									else {
									%>
							
										<br/><h4>Vous n'avez aucune adresse, n'hésitez pas à en ajouter !</h4>
							
									<%
									}
									%>
									
								</div>
							</div>		
							<div class="post">
								<h2 class="littletitle">Ajouter une adresse</h2>
								<div class="entry">
									<div style="clear: both;">&nbsp;</div>
									<form action="/address" method="post">
										<div>
											<label for="num">Numéro : </label><input type="text" value="" id="num"
											name="num" />
										</div>
										<div>
											<label for="nomRue">Nom de rue : </label><input type="text" value=""
											id="nomRue" name="nomRue" />
										</div>
										<div>
											<p class="links"><input class="button" type="submit" value="Valider" /></p>
										</div>
									</form>
								</div>
							</div>	
						</div>		
						<!-- end #content -->

							<%	
							} 
							else {
							//si l'utilisateur n'est pas loggué
							%>
						
								<h2 class="title">Bienvenue</h2>
									<p class="meta"><span class="posted">Mars 2013</span></p>					
							
									<div class="entry">
										<p>Cet outil <strong>révolutionnaire</strong> vous permettra d'être averti du jour de ramassage de vos <a>poubelles</a>...
										<br/><br/>
										Pour cela rien de plus simple :<br/>
										1. Connectez-vous avec votre compte Gmail<br/>
										2. Renseignez votre adresse postale
										</p>
										<div style="clear: both;">&nbsp;</div>
										<p> Vous serez averti en tant voulu par mail du jour de ramassage de vos poubelles
										<p class="links"><a href="<%=userService.createLogoutURL(request.getRequestURI())%>" class="button">Connexion</a></p>
									</div>
						</div>
						
						<div style="clear: both;">&nbsp;</div>
						
					</div>
						
										
							<%
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