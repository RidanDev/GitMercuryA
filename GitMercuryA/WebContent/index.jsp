<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css" type="text/css">
<script type="text/javascript">
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

<script>
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal 
	btn.onclick = function() {
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
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
		<a href="view/regUtente.jsp">Iscriviti alla Newsletter</a> 
		<a href="view/regEnte.jsp">Registrati come Ente</a> 
		<a href="#login" id="	">Login</a>
		<div id="myModal" class="modal">

			<!-- Modal content -->
			<div class="modal-content">
				<span class="close">&times;</span>
				Email:<input type="text" name="email"><br> 
				Password:<input type="password"	name="password"><br>
				<input type="submit" name="Accedi">
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="column side" style="background-color: #aaa;">
			<form>
				<fieldset>
					<legend>Cerca evento</legend>
					<div>
						Scegli il tipo di evento:
						<select>
							<option>---Select---</option>
						</select><br><br>
						Regioni:
						<select id="regioni" name="regioni"	onchange="populate()">
							<option>---Select---</option>
							<option value="toscana">toscana</option>
							<option value="liguria">liguria</option>
							<option value="marche">marche</option>
						</select><br><br>
						Province:
						<select id="province" name="province">
							<option>---Select---</option>
						</select><br><br>
						Comuni: <select id="comuni" name="comuni">
							<option>---Select---</option>
						</select><br><br>
					</div>
						<label for="start">Start</label>
						<input type="date" id="start" name="dataInizio" value="2018-07-22" min="2018-01-01" max="2018-12-31" />
						<br><br>
						<label for="end">End</label> <input type="date" id="end"
							name="dataFine" value="2018-07-29" min="2018-01-01"
							max="2018-12-31">
				</fieldset>
			</form>
		</div>
		<div class="column middle" style="background-color: #bbb;"></div>
		<div class="column side" style="background-color: #ccc;"></div>
	</div>

	<div class="footer">
		<p>Footer</p>
	</div>
	
<!--    https://www.w3schools.com/cssref/tryit.asp?filename=trycss_grid-row -->
</body>
</html>