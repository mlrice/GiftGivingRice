<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Edit a Person</title>
</head>
<body>
<form action= "EditPersonalRecipientServlet" method="post"> 
		Name: <input type="text" name="name" value="${pRecipientToEdit.name}"><br /> 
		Address: <input type="text" name="address" value="${pRecipientToEdit.streetAddress}"><br />
		City: <input type="text" name="city" value="${pRecipientToEdit.city}"><br />
		State: <input type="text" name="state" value="${pRecipientToEdit.state}">Please enter 2 position alphanumeric abbreviation<br />
		ZipCode: <input type="text" name="postalCode" value="${pRecipientToEdit.postalCode}"><br />
		BirthDate: <input type="text" name="birthDate" value="${pRecipientToEdit.birthDate}">Please enter in YYYY-MM-DD format<br /> 
 		Relationship: <input type="text" name="relationship" value="${pRecipientToEdit.relationship}"><br />
 		<input type="hidden" name="id" value="${pRecipientToEdit.id}"> 
 		<input type="submit" value="Save Edited Recipient">
 </form>

</body>
</html>