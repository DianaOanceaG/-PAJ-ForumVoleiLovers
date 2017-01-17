<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum Volleyball Lovers</title>
</head>
<body>
<form action="forum" method="post" >
<fieldset style="display: inline-block; background-image: url('minge.jpg');">
<legend style="color: red; font: bold; font-size: large;">Login to talk volleyball</legend>
<table>
<tr>
	<td>Username</td>
	<td><input type="text" name="username"  style=" height : 22px;" /></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="passwd" style=" height : 22px;"/>
</tr>
</table>
<table>
<tr style=" width : 217px;">
	 <td align="center" style=" width : 137px;"><input type = "submit" value="Login" style="color: blue; display: inline-block; position: center;" />
</td>
<td align="center">
<a href="./ContForum.jsp">Registration</a>
</td>
</tr>
<tr><td align="center" height="30"> ${mesaj_login} </td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>