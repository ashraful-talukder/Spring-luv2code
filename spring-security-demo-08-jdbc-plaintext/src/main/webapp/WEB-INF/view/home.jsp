<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>luv2code company</title>
</head>
<body>
	<h2>welcome to the luv2code company home page!</h2>
	
	<hr>
	
	<!-- display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>	
	
	<security:authorize access="hasRole('Manager')">
	
		<!-- Add a link to point to / leaders ... this is for the managers-->
		
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
	
	</security:authorize>
		
	<security:authorize access="hasRole('CEO')">
	
		<!-- Add a link to point to /systems...this is for the CEO -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">System Setting</a>
			(Only for Management peeps)
		</p>
	
	</security:authorize>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>