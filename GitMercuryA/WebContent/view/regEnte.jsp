<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/form.css" type="text/css">
<script type="text/javascript" language="javascript">
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
<title>Registrazione Utente</title>
</head>
<body bgcolor="black">
	<div class="header">
   	 	<h2>Mercury</h2>
  	</div>
  	
	<div class="topnav">
		<a href="../index.jsp">Home</a>
		<a href="cercaEvento.jsp">Cerca evento</a> 
		<a href="regUtente.jsp">Iscriviti alla Newsletter</a> 
		<a href="regEnte.jsp">Registrati come Ente</a> 
		<a href="login.jsp">Accedi</a> 
	</div>
	
	<div class="form">
		<form method="post" action="../TestNewsletter" name="regForm" style="padding: 40px 100px;">
			<fieldset>
				<legend>Registrazione Ente</legend>
				<ol>
	 				<li>Inserire nome Ente:</li>
				</ol>           	
           		<input type="text" name="nomeEnte" placeholder="Inserire nome Ente..">
           		<ol start="2">
           			<li>Inserire ragione Sociale:</li>
           		</ol>
           		<input type="text" name="ragSociale" placeholder="Inserire ragione Sociale..">
           		<ol start="3">	
           			<li>Inserire Partita Iva:</li>
           		</ol>
           		<input type="text" name="pIva" placeholder="Inserire partita Iva..">
           		<ol start="4">	
           			<li>Inserire numero telefonico Ente:</li>
           		</ol>
           		<input type="text" name="telefonoEnte" placeholder="Inserire numero telefonico..">
				<ol start="5">	
					<li>Inserire email:</li>
				</ol>
				<input type="text" name="emailEnte" placeholder="Inserire email Ente..">
    			<ol start="6">	
    				<li>Scegli una Password:</li>
    			</ol>	
    			<input type="password" name="passEnte" placeholder="Inserire password..">
	   		</fieldset>
			<input type="submit" name="Invia" value="Registrati">
		</form>
	</div>
</body>
</html>