<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customer Registration Form</title>
	<style>
		.error{color:red}
	</style>
</head>
<body>

	<i>You must have to fill up the form where Asterisk(*) available</i>
	
	

	<form:form action="processForm" modelAttributes="customer"> 
		First name: <form:input path="firstName"/> 
		
		<br> <br>
		
		Last name<p style="color:red;">*</p>: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br> <br>
		
		<input type="submit" value="submit"/>
	</form:form>
	
</body>
</html>