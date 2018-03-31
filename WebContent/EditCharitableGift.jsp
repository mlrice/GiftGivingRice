<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Edit a Charitable Gift</title>
</head>
<body>
<form action= "EditCharitableGiftServlet" method = "post">
	Date Given: <input type="text" name = "date" value="${cGiftToEdit.dateGiven}"><br />
	Description: <input type="text" name="description" value="${cGiftToEdit.description}"><br />
	Value: <input type="text" name="value" value="${cGiftToEdit.value}"><br />
	<c:choose>
	<c:when test = "${cGiftToEdit.taxDeductible}">
		<input type = "checkbox" name="taxDeductible" checked/> Gift is tax deductible</c:when>
	<c:otherwise>
		<input type = "checkbox" name="taxDeductible"/> Gift is tax deductible</c:otherwise>
	</c:choose>
	<br />
	<c:choose>
	<c:when test = "${cGiftToEdit.haveReceipt}">
		<input type = "checkbox" name="haveReceipt" checked/> You have a receipt</c:when>
	<c:otherwise>
		<input type = "checkbox" name="haveReceipt"/> You have a receipt</c:otherwise>
	</c:choose>	
	<br />
	<input type="hidden" name="id" value="${cGiftToEdit.id}">
	<input type="submit" value="Save Edited Gift">
	

	</form>
</body>
</html>