<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Inbox</h1>
<div align="left">|
<a href="compose">Compose</a>|
<a href="inbox">Inbox</a>|
<a href="sent">Sent</a>|
<a href="draft">Draft</a>|
<a href="changepass">ChangePassword</a>|
<a href="deleteMail">DeletedMail</a>|

</div>

<h3><table border='1'><tr><th>Mail Id</th><th>Messages</th><th>Delete</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td><center>${dto.getToId() }</center></td><td><center><a href="message?id=${dto.getId() }">${dto.getMessage() } </a></center></td><td><a href="inboxdelete?id=+${dto.getId() }+">delete</a></td></tr><br>
</c:forEach>
<br><br>
</table>
</center>
</body>
</html>