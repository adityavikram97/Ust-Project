<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Welcome to Home Page:${dto.getUsername() }</h1></center>

<h3 style="color:#00bfff">${msg1 }</h3>
${msg }
${dto1 }
<h3 style="text-align:center;background-color: aqua"> <a href="addproduct">Add Product</a>|<a href="search">Search Products</a>
|<a href="viewproducts">View Products</a>|<a href="logout">Logout</a></h3>
</body>
</html>