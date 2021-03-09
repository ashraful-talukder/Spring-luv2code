<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName"/>	

		<br><br>
		
		Last Name: <form:input path="lastName"/>
		
		<br> <br>
		
		Country:
		
		<form:select path="country">
		
			<form:option value="America" label="America"></form:option>
			<form:option value="France" label="France"></form:option>
			<form:option value="Bangladesh" label="Bangladesh"></form:option>
			<form:option value="India" label="India"></form:option>
			<form:option value="Pakistan" label="Pakistan"></form:option>
		
		</form:select>	
	
		<br><br>
	
		<input type="submit" value="submit"/>
		
	</form:form>
	
</body>
</html>