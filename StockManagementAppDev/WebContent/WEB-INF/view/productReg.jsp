<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<h1>Welcome to add product page</h1>
<br>
${dto1 }
<div align="center"  >
<fieldset >
<style>
fieldset{
width: 350px
}
</style>
<div style="background-color: aqua">

<form action="additem" method="post">
<pre>
Product Name<br>
<input type="text" name="name" required><br>

<label for=""><b>Category</b></label>
<select name="category" required="required">
<option value="">select</option>
<option value="Electronics">Electronics</option>
<option value="Pantry">Pantry</option>
<option value="cloths">Cloths</option>
	
</select>


Company Name<br>
<input type="text" name="company" required><br>
Quantity<br> 
<input type="number" name="quantity" required><br>

Price<br>
<input type="number" name="price" required><br>
<input type="submit" value="Add Product">
</pre>
</form>
</div>
</fieldset>
</div>
</body>
</html>