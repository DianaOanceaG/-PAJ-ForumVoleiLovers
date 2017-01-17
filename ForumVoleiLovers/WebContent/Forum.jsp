<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum Volleyball Lovers</title>
</head>
<body style="display: inline-block; background-image: url('fileu.jpg');">
	<table>
	<tr>
	<td>
		<div id="subiecte">
					<%
	String recset = (String) request.getAttribute("recordset");
	out.print(recset);
%>
		</div>
	<td style="padding-left: 200px;">
	<form action="AddSubiecte" method="POST">
		<fieldset>
			<legend style="color: red;">Creare subiect</legend>
			  <table>
			  		<tr>
			  			<td style="color: red;">
			  				Continut subiect
			  			</td>
			  			<td>
			  				<input type="text" name="denumiresub" />
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="center" height="30" style="color: red;"> ${mesaj_add}</td>
			  			<td>
			  				<input type="submit" value="Creare" />
			  			</td>
			  		</tr>
			  </table>
		</fieldset>
	</form>
	</td>
	</tr>
	</table>>
</body>
</html>