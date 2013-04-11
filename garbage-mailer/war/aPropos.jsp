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
				<li><a href="index.jsp">Homepage</a></li>
				<li class="current_page_item"><a href="apropos.jsp">A propos</a></li>

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

		<h2 class="littletitle">Vous habitez à Nantes</h2>
		<div class="entry">

Depuis le lundi 2 janvier 2012, des changements ont été apportés dans le service de la collecte : bac bleu, bac jaune et Tri’sac. La collecte sélective est étendue à de nouveaux quartiers, avec un ramassage hebdomadaire (le mercredi) pour les bacs jaunes. Pour 50000 foyers, cela s’accompagne d’un seul passage pour les déchets ménagers. 80% des Nantais ont ainsi la possibilité de faire le tri sélectif chez eux.
<div style="clear: both;">&nbsp;</div>
Vos déchets peuvent être collectés :
<ul>
	<li>en bacs bleus</li>
 	<li>en bacs bleus et bacs jaunes</li>
 	<li>en tri’sac</li>
 </ul>

Parallèlement, de nouvelles consignes de tri vont être testées par 90000 Nantais qui seront détenteurs de bacs jaunes. Une expérimentation qui va durer deux ans.
<a href="http://www.nantesmetropole.fr/pratique/dechets/de-nouveaux-dechets-passent-le-bac--45018.kjsp?RH=1250009878138">En savoir plus</a>
<div style="clear: both;">&nbsp;</div>
Vous habitez Basse-Goulaine, Bouaye, Bouguenais, Brains, Carquefou, Couëron, Indre, Mauves-sur-Loire, La Montagne, Orvault, Le Pellerin, Les Sorinières, St-Aignan-de-Grand-Lieu, Rezé, Saint-Herblain, Saint-Jean de Boiseau, Saint-Sébastien-sur-Loire, Sautron, St-Léger-les-Vignes, Vertou, les Ordures Ménagères résiduelles sont collectées 1 fois par semaine.
<div style="clear: both;">&nbsp;</div>
Sur les communes de La Chapelle-sur-Erdre, Mauves-sur-Loire, Sainte-Luce-sur-Loire, Thouaré-sur-Loire, Vertou, les ordures ménagères sont collectées 2 fois par semaine.
<div style="clear: both;">&nbsp;</div>
Quelques grands collectifs de l’agglomération comme à Orvault ou Rezé sont collectés jusqu’à 6 fois par semaine.
	</div>
									
		</div>
	</div>		
						
		</div>		
		<!-- end #content -->

	
	</div>

					<div style="clear: both;">&nbsp;</div>

				</div>

				<!-- end #content -->

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