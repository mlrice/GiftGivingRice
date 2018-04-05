<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #FF33FE;
}

h1 {
	color: blue;
	font-family: verdana;
	font-size: 190%;
	margin: 20px;
	text-align: center;
}

h3 {
	color: blue;
	font-family: verdana;
	font-size: 140%;
	margin: 5px 5px 5px 0px;
	text-align: left;
}

p {
	color: blue;
	font-family: verdana;
	font-size: 140%;
	margin: 5px;
}

input[type=submit] {
	padding: 5px 15px;
	background: #ccc;
	border: 0 none;
	cursor: pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-size: 21px;
	background-color: #808080;
	font-weight: bold;
	text-shadow: 1px 1px #808080;
	color: #ffffff;
	margin: 15px 15px 15px 55px;
}

a:link {
	color: purple;
	font-family: verdana;
	font-size: 125%;
	font-weight: bold;
	margin: 55px 55px 55px 55px;
}

/* visited link */
a:visited {
	color: purple;
}
/* mouse over link */
a:hover {
	color: red;
}
/* selected link */
a:active {
	color: yellow;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Gift List</title>
</head>
<body>
<h1>Your Personal Giving</h1>
<form method = "post" action = "EditPersonalGiftListServlet">
<table>
<c:forEach items="${requestScope.allPersonalGifts}" var="currentGift">
<tr>
	<td><input type="radio" name="id" value="${currentGift.id}"></td>
	<td>Date Given: ${currentGift.dateGiven}</td>
	<td>Description: ${currentGift.description}</td>
	<td>Value: $${currentGift.value}</td>
	
	
	<td><input type = "hidden" name="rId" value="${currentGift.recipient}"></td>
	</tr>
</c:forEach>	
</table>
<input type = "submit" value = "Edit Selected Gift" name="doThisToGift">
<input type = "submit" value = "Delete Selected Gift and Recipient" name="doThisToGift">
<input type = "submit" value = "Add New Gift" name="doThisToGift">
</form>
<a href= "index.html">Back to option list</a><br />
</body>
</html>