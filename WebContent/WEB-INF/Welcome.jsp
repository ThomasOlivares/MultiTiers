<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>

<h2>Bienvenue sur le service d'autentification</h2>

<form action="AutentificationUser" method="POST">
Login: <input type="text" name="login">
<br />
Password: <input type="text" name="mdp" />
<br />
Allow cookies: <input type="checkbox" name="cookies" />
<br/>
<input type="submit" value="Connexion" />
</form>

</body>
</html>