<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: powderblue;
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
	background-color: #F36C8C;
	font-weight: bold;
	text-shadow: 1px 1px #F36C8C;
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
<title>Charity Recipient List</title>
</head>
<body>
<h1>Charity Recipients</h1>
<form method = "post" action = "EditCharitableRecipientListServlet">
<table>
<c:forEach items="${requestScope.charityList}" var="currentRecipient">
<tr>
	<td><input type="radio" name="id" value="${currentRecipient.id}"></td>
	<td>Name: ${currentRecipient.name}</td>
	<td>Address: ${currentRecipient.streetAddress}</td>
	<td>City: ${currentRecipient.city}</td>
	<td>State: ${currentRecipient.state}</td>
	<td>Zip: ${currentRecipient.postalCode}</td>
	<td>TaxID: ${currentRecipient.taxID}</td>
	</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Recipient" name = "doThisToCRecipient">
</form>
<a href= "index.html">Back to option list</a><br />

</body>
</html>