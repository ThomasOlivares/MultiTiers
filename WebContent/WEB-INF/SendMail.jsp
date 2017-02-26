<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Received mails</title>
</head>
<body>
	<h1>Received mails:</h1>
	 <p>
            <% 
            String attribut = (String) request.getAttribute("message");
            out.println( attribut );
            %>
        </p>
</body>
</html>