<%@page import="classes.Requete"%>
<%@page import="beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<html>
<body>
	<%
		//On récupère le user.
		UserService userService = UserServiceFactory.getUserService();
		User userGoogle = userService.getCurrentUser();
		//S'il est loggué
		if (userGoogle != null) {
	%>
	<p>
		Bonjour,
		<%=userGoogle.getNickname()%>! <br />

		<%
			//on récupère le user en BDD

				List<UserBean> listeUb = Requete.getUser(userGoogle.getEmail());

				//si la liste n'est pas vide, on affiche les adresses
				if (listeUb != null) {
		%>
	
	<TABLE BORDER="1">
		<CAPTION>Vos addresses</CAPTION>
		<TR>
			<TH>Numéro</TH>
			<TH>Adresse</TH>
			<TH>Bleu</TH>
			<TH>Jaune</TH>
			<TH>Tri'sac</TH>
			<TH>Supprimer l'adresse</TH>
		</TR>
		<%
			for (UserBean ub : listeUb) {
		%>
		<TR>
			<TH><%=ub.getNumero()%></TH>
			<TH><%=ub.getAddress()%></TH>
			<TH><%=ub.getBleu()%></TH>
			<TH><%=ub.getJaune()%></TH>
			<TH><%=ub.getTriSac()%></TH>
			<TH><a href="/delAddress?idDel=<%=ub.getRivolli()%>">supprimer</a></TH>
		</TR>
		<%
			}
		%>
	</TABLE>
	<%
		} else {
	%>
	<h4>Vous n'avez aucune adresse, n'hésitez pas à en ajouter!</h4>
	<%
		}
	%>


	<p>Ajouter une adresse</p>
	<br />
	<form action="/address" method="post">
		<div>
			<label for="num">Numéro</label><input type="text" value="" id="num"
				name="num" />
		</div>
		<div>
			<label for="nomRue">Nom de rue</label><input type="text" value=""
				id="nomRue" name="nomRue" />
		</div>
		<div>
			<input type="submit" value="Valider" />
		</div>
	</form>
	<br />

	<form action="/mail" method="post">
		<div>
			<input type="submit" value="TEST - Envoyer un mail à nicolas.dufour.ndr" />
		</div>
	</form>

	<a href="<%=userService.createLogoutURL(request.getRequestURI())%>">deconnexion</a>.
	<%
		//si l'utilisateur n'est pas loggué
		} else {
	%>
	<h1>Bienvenue dans le Garbage Mailer!</h1>
	<p>
		Cet outil révolutionnaire vous permettra d'être averti du jour de
		ramassage de vos poubelle... Pour cela? Rien de plus simple : <br />
		1 - Se connecter <br /> 2 - Renseigner son adresse <br /> 3 - Etre
		averti en temps voulu du passage du camion poubelle <br />
	</p>

	<h2>Connexion :</h2>
	<a href="<%=userService.createLoginURL(request.getRequestURI())%>">Ici</a>

	<%
		}//fin if loggué else
	%>
</body>
</html>