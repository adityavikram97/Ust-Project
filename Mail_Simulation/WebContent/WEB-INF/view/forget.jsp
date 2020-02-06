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
<h1>Forget Password</h1>
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<div style="background-color: aqua">
<form action="forgetPass" method="post">
<pre>
    Email         :<input type="email" name="email" required="required"><br>

<label for=""><b>Security Question</b></label>
<select name="security_question" required="required">
<option value="">select</option>
<option value="what is your nickname?">what is your nickname?</option>
<option value="what is your collegename?">what is your collegename?</option>
<option value="what is your birth place?">what is your birth palce?</option>
	
</select><br><br>
Security Answer   :<input type="text" name="security_answer"><br>
 New  Password    :<input type="password" name="password"><br>
 Confirm Password :<input type="password" name="password1"><br>
                   <input type="submit" value="submit"><br>
        <h4> ${msg } </h4>
        </pre>
</form>
</div>
</fieldset>
</center>
</body>
</html>