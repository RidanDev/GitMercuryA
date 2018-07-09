<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/form.css" type="text/css">
<script type="text/javascript" language="javascript">

// function populateP() {
// 	var regione=document.getElementById('regione').value;
// 	var httpRequest = new XMLHttpRequest();
// 	httpRequest.open("GET", 'RegProvCom?rpc='+regione , true);
// 	httpRequest.onload = function(){
// 		if(this.status == 200){
// 			document.getElementById('province').innerHTML = this.responseText;
// 	 	}else if(this.status == 400){
// 	 		  document.getElementById('contenuto').innerHTML = "Risorsa non trovata!";
// 	 	}
// 	 httpRequest.send();
// 	 }
// }



// 	var valoreZona=null;
// 	var valoreCadenza=null;
// 	function validaInvio(){
// 		if(valoreZona==null){
// 			alert("Selezionare il luogo di interesse");
// 			return false;
// 		}
// 		if(document.regForm.luogoInteresse.value.equals("")|| 
// 				document.regForm.luogoInteresse.value.equals("Inserire nome della località selezionata")){
// 			alert("Scrivere la località di tuo interesse");
// 			return false;
// 		}
// 		if(valoreCadenza==null) {
// 			alert("Selezionare quando ricevere le email");
// 			return false;
// 			}
// 		return false;
// 	}
</script>
<title>Iscrizione</title>
</head>
<body bgcolor="black">
	<div class="header">
   	 	<h2>Mercury</h2>
  	</div>
  	
	<div class="topnav">
		<a href="../index.jsp">Home</a>
		<a href="regUtente.jsp">Iscriviti alla Newsletter</a> 
		<a href="regEnte.jsp">Registrati come Ente</a> 
		<a href="login.jsp">Accedi</a> 
	</div>
	
	<div class="form">
		<form method="post" action="../NewsletterController" name="iscrizione" style="padding: 40px 100px;">
			<fieldset>
				<legend>Iscriviti alla Newsletter</legend>
				<ol style="padding-left: 40px; ">
	 				<li>Inserisci il luogo di interesse:</li>
	 			</ol>
	 				<div class="radio">
	   					<select id="regione" name="regione" required onchange="populateP()">
							<option>REGIONE</option>
							<option value="2">Val d'Aosta</option>
							<option value="1">Piemonte</option>
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
						<select id="provincia" name="provincia" required onchange="populateC()">
							<option>PROVINCIA</option>
							<option value="1">Torino</option>
						</select>
						<select id="comune"	name="comune" required>
							<option>COMUNE</option>
						</select>
					</div>
				<ol start="2">
					<li>Seleziona quali categorie di eventi ti interessano</li>
				</ol>
					<div class="checkbox">
						<input type="checkbox" name ="genere" value="concerti">Concerti <br>
						<input type="checkbox" name ="genere" value="convegni">Convegni <br>
						<input type="checkbox" name ="genere" value="enogastronomia e sagre">Enogastronomia e sagre <br>
   						<input type="checkbox" name ="genere" value="film">Film <br>
						<input type="checkbox" name ="genere" value="festival">Festival <br>
						<input type="checkbox" name ="genere" value="manifestazioni sportive">Manifestazioni sportive <br>
						<input type="checkbox" name ="genere" value="mostre">Mostre <br>
						<input type="checkbox" name ="genere" value="teatro">Teatro <br>
					</div>
				<ol start="3">	
    				<li>Con quale cadenza vuoi ricevere le email?</li>
    			</ol>	
    				<div class="radio">
						<input type="radio" name="cadenza" value="settimanale" checked>Settimanale &emsp;
						<input type="radio" name="cadenza" value="mensile">Mensile &emsp;
						<input type="radio" name="cadenza" value="annuale">Annuale &emsp;
					</div>
				<ol start="4">	
					<li>Inserisci l'email in cui vuoi ricevere le news:</li>
				</ol>	
					<input type="text" placeholder="Inserisci email.." name="email" required>
	   		</fieldset>
			<input type="submit" name="Invia" value="Iscriviti alla Newsletter">
		</form>
	</div>
</body>
</html>