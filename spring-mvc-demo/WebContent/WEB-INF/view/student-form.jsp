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
		
			<form:options items="${student.countryOptions}"/>
		
		</form:select>
		
		<br> <br>
		
		Favorite Language: <br>
		
		Java<form:radiobutton path="favoriteLanguage" value="Java"/>	
		C#<form:radiobutton path="favoriteLanguage" value="C#"/>	
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>	
		Python<form:radiobutton path="favoriteLanguage" value="Python"/>	
		R<form:radiobutton path="favoriteLanguage" value="R"/>	
	
		<br><br>
	
		<input type="submit" value="submit"/>
		
	</form:form>
	
</body>
</html>