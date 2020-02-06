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
<h1>Welcome To Registration Page</h1>
<h4>${m }</h4><br>
<fieldset>
<style >
fieldset{
width: 350px;
height: 380px;
}
</style>
<div  style="background-color:aqua">
<form  action="rigistration"  method="post">
<pre>
    <b>User Name </b>      
<input type="text" name="userName" required="required"><br>
  <b>Email</b>         
<input type="email" name="email" required="required"><br>

<label for=""><b>Security Question</b></label>
<select name="security_question" required="required">
<option value="">select</option>
<option value="what is your nickname?">what is your nickname?</option>
<option value="what is your collegename?">what is your collegename?</option>
<option value="what is your birth place?">what is your birth palce?</option>
	
</select>


   <b>Security Answer </b> 
<input type="text" name="security_answer" required="required"><br>
   <b>Password</b>        
<input type="password" name="password" required="required"><br>
<input type="submit" value="Register">||<button><a href="login">login</a></button>
</pre>
</form>
</div>
</fieldset>
</center>
</body>
</html>