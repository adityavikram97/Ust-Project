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
<h1>Welcome To Login Page</h1>
<h4>${m }</h4>
<h4>${msg1 }</h4>
<h4>${msg }</h4><br>
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<div style="background-color: aqua">
<form action="login"  method="post" >
<pre>
<b>Email:</b>
<input type="email" name="email" required="required"><br>
<b>Password:</b>  
<input type="password" name="password" required="required"><br>
 <button><input type="submit" value="login"><br></button><br>
<button><a href="forget">forget password</a></button> | <button><a href="rigistration">Register</a></button>
</pre>
</form>
</div>
</fieldset>
</center>
</body>
</html>