<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.mercurya.model.Ruolo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.mercurya.model.Evento"%>
<%@ page import="it.mercurya.model.Comune"%>
<%@ page import="it.mercurya.model.Provincia"%>
<%@ page import="it.mercurya.model.Regione"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css" type="text/css">
<script>
	var modal = document.getElementById('bottoneLogin');
	window.onclick = function(event) {
    	if (event.target == modal) {
        	modal.style.display = "none";
    	}
	}

	function populate() {
		var regione = document.getElementById('regioni').value;
		var ajax = new XMLHttpRequest();
		ajax.open('GET', 'RegProvCom?reg=' + regione, true);
		ajax.onload = function() {
			if (this.status == 200) {
				document.getElementById('province').innerHTML = this.responseText;
			} else if (this.status == 400) {
			}
		}
		ajax.send();
	}
</script>
<title>Home</title>
</head>
<body bgcolor="black">
	
	<div class="header">
		<h2>Mercury</h2>
	</div>

	<div class="topnav">
		<a href="index.jsp">Home</a>
		<%
			Ruolo ruolo=(Ruolo)session.getAttribute("ruolo");
			if(ruolo!=null){
				if(ruolo.getNome().equals("Ente")){
					out.println("<a href='view/creaEvento.jsp'>Crea evento</a>");
					out.println("'<a href='view/mieiEventi.jsp'>I miei eventi</a>'");
					out.println("<button class='logBut' onclick=...> Logout </button>");
				}
				else if(ruolo.getNome().equals("Amministratore")){
					out.println("<a href='view/listaEnti.jsp'>Enti registrati</a>");
					out.println("<button class='logBut' onclick=...> Logout </button>");
				}
			} else{
					out.println("<a href='view/regUtente.jsp'>Iscriviti alla Newsletter</a>"); 
					out.println("<a href='view/regEnte.jsp'>Registrati come Ente</a>");
					out.println("<button class='logBut' onclick=\"document.getElementById('bottoneLogin').style.display='block'\"> Login </button>");
			}	
		%>  
	</div>
	
	<div id="bottoneLogin" class="modal">
  
  		<form class="modal-content animate" action="../......" method="post">
    		<div class="imgcontainer">
      			<span onclick="document.getElementById('bottoneLogin').style.display='none'" class="close" title="Close PopUp">&times;</span>
      			<h1 style="text-align:center">Inserisci le tue credenziali</h1>
    		</div>

    		<div class="container">
      			<input type="text" placeholder="Email.." name="uname">
      			<input type="password" placeholder="Password.." name="psw">        
      			<button class="formLog" type="submit">Login</button>
    		</div>
  		</form>
	</div>
	<div class="row"  >
		<div class="column side"  style="background-color: #aaa;">
			<form>
				<fieldset>
					<legend style="font-weight: bold;">Cerca evento</legend>
					<div>
						Categoria:
						<select>
							<option>---Select---</option>
						</select><br><br>
						Regioni:
						<select id="regioni" name="regioni"	onchange="populate()">
							<option>---Select---</option>
							<option value="toscana">Toscana</option>
							<option value="liguria">Liguria</option>
							<option value="marche">Marche</option>
						</select><br><br>
						Province:
						<select id="province" name="province">
							<option></option>
						</select><br><br>
						Comuni: <select id="comuni" name="comuni">
							<option></option>
						</select><br><br>
					</div>
					<!-- ciao -->
						Inizio evento:
						<input type="date" id="start" name="dataInizio" value="2018-07-22" min="2018-01-01" max="2018-12-31" />
						<br><br>
						Fine evento:
						<input type="date" id="end"	name="dataFine" value="2018-07-29" min="2018-01-01"	max="2018-12-31">
						<br>
						<input type="submit" name="Cerca" value="Cerca">
				</fieldset>
			</form>
		</div>
		<div class="column middle" class="col-container" style="background-color: #bbb;">
			<div class="eventi">
			
			
			<%
					
			ArrayList<Evento> elist = (ArrayList<Evento>)session.getAttribute("lista_eventi_non_scaduti");
			
			
			
			for(int i=0;i<elist.size();i++){
				out.println("<div class=\"eventi1\"><div>");
				out.println("<b>" + elist.get(i).getNome() + "</b><br>");
				out.println("Dal: " + elist.get(i).getInizio() + " ");
				out.println("Al: " + elist.get(i).getFine() + "<br>");
				/////
				out.println("Genere evento: " + elist.get(i).getGenere_nome().getNome() + "<br>");
				/////
				out.println("Publicato da: " + elist.get(i).getEnte_Utente_email().getNome() + "<br>");
				out.println("Email: " + elist.get(i).getEnte_Utente_email().getEmail() + " | ");
				out.println("Telefono: " + elist.get(i).getEnte_Utente_email().getTelefono() + "<br>");
				/////
				Comune c = elist.get(i).getComune_id();
				//out.println("ID comune: " + c.getId() + "<br>");
				out.println("Comune: " +c.getNome() + " | ");
				
				Provincia p = c.getProvincia_id();
				//out.println("ID provincia: " + p.getId() + "<br>");
				out.println("Provincia: " + p.getNome() + " | ");
				
				Regione r = p.getRegione_id();
				//out.println("ID regione: " + r.getId() + "<br>");
				out.println("Regione: " + r.getNome() + "<br>");
				/////
				//out.println("Abilitato: " + elist.get(i).isEnabled() + "<br>");
				
				out.println("</div></div><hr>");
			}
			
			%>
			
			</div>
		</div>
		<div class="column side" class="col-container" style="background-color: #ccc;"></div>
	</div>

	
	
</body>
</html>