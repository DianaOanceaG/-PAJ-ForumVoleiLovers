<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
  <form action="AddContServlet" method="POST">
  <fieldset style="display: inline-block; background-image: url('mingevolei.jpg');">
  <legend>Formular de înregistrare</legend>
  <table border="1">
  	<tr>
  		<td>Nume:</td>
  		<td>
  		<input type="text" name="nume" />
  		</td>
  	</tr>
  	<tr>
  		<td>Prenume:</td>
  		<td>
  		<input type="text" name="prenume" />
  		</td>
  	</tr>
  	<tr>
  		<td>E-mail:</td>
  		<td>
  		<input type="text" name="email" />
  		</td>
  	</tr>
  	<tr>
  		<td>Username:</td>
  		<td>
  		<input type="text" name="username" />
  		</td>
  	</tr>
  	<tr>
  		<td>Parola:</td>
  		<td>
  		<input type="password" name="parola" />
  		</td>
  	</tr>
  	<tr >
 <td>
	 <input type = "submit" value="Register" style="color: blue; display: inline-block; position: center;" />
	 <td>
</tr>
<tr>
<td>
<a href="./LoginForum.jsp">Înapoi la Login...</a>
</td>
<td align="center" height="30"> ${mesaj_login}</td></tr>
  </table>
  </fieldset>
  </form>
</body>
</html>