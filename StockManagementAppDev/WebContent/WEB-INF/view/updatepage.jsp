<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<h1 align='center'>Update  item Page</h1>
<h3 align="left">${msg1 }</h3>
<h4 align='center'>
<div align="center"  >
<fieldset >
<style>
fieldset{
width: 350px
}
</style>
<div style="background-color: aqua">
	
<form action='updateitem' method='post'>
<input type='hidden' name='id' value="${obj.getProductid() }"><br>
Product Name<br>
<input type='text' name='name' value="${obj.getName() }"><br><br>

<label for=""><b>Category</b></label>
<select name="category" value="${obj.getCategory() }" required="required">
<option value="">select</option>
<option value="Electronics">Electronics</option>
<option value="Pantry">Pantry</option>
<option value="cloths">Cloths</option>
	
</select>
<br><br>
Product Company<br>
<input type='text' name='company' value="${obj.getCompany() }"><br>
Product Quantity<br>
<input type='number' name='quantity' value="${obj.getQuantity() }"><br>
Product Price<br>
<input type='number' name='price' value="${obj.getPrice() }"><br><br>
<input type='submit' value='Update'>
</form>
</div>
</fieldset>
</div>			
</h4>
</body>
</html>