<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/ricerca.css" type="text/css">
<title>Ricerca</title>
</head>
<body bgcolor="black">

	<div class="header">
		<h2> Benvenuto su Mercury!</h2>
	</div>

	<div class="topnav">
		<a href="../index.jsp">Home</a>
		<a href="ricerca.jsp">Cerca evento</a> 
		<a href="regUtente.jsp">Iscriviti alla Newsletter</a> 
		<a href="regEnte.jsp">Registrati come Ente</a> 
		<a href="login.jsp">Accedi</a> 
	</div>
	
	<div class="form" style="background-color: gray;" >
		<form method="post" action="../TestNewsletter" name="iscrizione" style="padding: 40px 100px;">
			<fieldset>
				<legend>Cerca evento</legend>
	 			<div class="radio">
	   				<select id="regione" name="regione" onchange="populateP()">
						<option>REGIONE</option>
						<option value="valdaosta">Val d'Aosta</option>
						<option value="piemonte">Piemonte</option>
						<option value="liguria">Liguria</option>
						<option value="lombardia">Lombardia</option>
						<option value="veneto">Veneto</option>
						<option value="trentino">Trentino Alto Adige</option>
						<option value="friuli">Friuli Venezia-Giulia</option>
						<option value="emilia">Emilia-Romagna</option>
						<option value="toscana">Toscana</option>
						<option value="marche">Marche</option>
						<option value="umbria">Umbria</option>
						<option value="lazio">Lazio</option>
						<option value="abruzzo">Abruzzo</option>
						<option value="molise">Molise</option>							
						<option value="campania">Campania</option>
						<option value="basilicata">Basilicata</option>
						<option value="puglia">Puglia</option>
						<option value="calabria">Calabria</option>
						<option value="sicilia">Sicilia</option>
						<option value="sardegna">Sardegna</option>
					</select>
					<select id="provincia" name="provincia" onchange="populateC()">
						<option>PROVINCIA</option>
					</select>
					<select id="comune"	name="comune">
						<option>COMUNE</option>
					</select><br><br>
					Seleziona quali categorie di eventi ti interessano
					<select name ="genere">
						<option></option>			
						<option value="concerti">Concerti </option>
						<option value="convegni">Convegni </option>
						<option value="enogastronomia e sagre">Enogastronomia e sagre </option>
   						<option value="film">Film </option>
						<option value="festival">Festival </option>
						<option value="manifestazioni sportive">Manifestazioni sportive </option>
						<option value="mostre">Mostre </option>
						<option value="teatro">Teatro </option>
					</select><br><br>
				    Data inizio: 
					<input type="date" id="start" name="dataInizio" value="2018-01-01" min="2018-01-01"	max="2020-12-31">
					<br><br> 
					Data fine: 
					<input type="date" id="end" name="dataFine" value="2018-01-01" min="2018-01-01"	max="2020-12-31">
					<input type="submit" value="Cerca">
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>