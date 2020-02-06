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
<h1>Compose mail</h1>
<form action="compose1">
<pre style="background-color: aqua">
from: ${adto.getFromId() }<br>
to:   
<input type="email" name="to" value =${adto.getToId() } required="required"><br>
sub:  
<input type="text" name="sub" value =${adto.getSubject() }><br>
Message: 
<input type="text" name="body" value=${adto.getMessage() }><br>
<input type="submit" value="sent"><br>
</pre>
</form>
</center>
</body>
</html>