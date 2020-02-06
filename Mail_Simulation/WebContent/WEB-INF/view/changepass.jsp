<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Change Password</h1>
<form action="changepass" method="post">
<pre>
  New Password    
<input type="password" name="password"><br>
 Confirm Password 
 <input type="password" name="password1"><br>
 <input type="submit" value="submit">
 <h4> ${msg } </h4>
  </pre>
</form>
</center>
</body>
</html>