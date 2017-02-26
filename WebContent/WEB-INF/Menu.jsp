<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>

<h1> Send an email:</h1>

<form action="SendMailServlet" method="GET">
To: <input type="text" name="to" />
<br />
Subject: <input type="text" name="subject" />
<br />
Message: <input type="text" name="message" />
<input type="submit" value="Submit" />
</form>

<h1> Receive all your mails:</h1>
<br> <a href="ReceiveMailServlet"> Here</a>
<h1> Delete all the mails you already read:</h1>
<br> <a href="DeleteReadMailServlet"> Here</a>
</body>

<h1> Logout:</h1>
<a href = "http://localhost:8080/MVC_Olivares_Vignat/DeconnexionUser">Logout</a>

</body>
</html>