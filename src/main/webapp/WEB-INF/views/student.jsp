<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>
	<h1>Spring Boot - MVC web application example</h1>
  	<h2>allmess: ${messageSource.messages}</h2>
  	<h2><springForm:errors /></h2>
	<hr>
	
	<h2>Student</h2>
	<!-- <form action="student/save" method="post" > -->
    <form action="student/saveClass" method="post" >
      <table>
        <tr>
          <td>Name</td>
          <td><input id="name" name="name" value="${student1.name}"></td>
        </tr>
        <tr>
          <td>Hobby</td>
          <td><input id="hobby" name="hobby"></td>
        </tr>
        <tr>
          <td>Hobby</td>
          <td><input id="phone" name="phone"></td>
        </tr>
        <tr>
          <td>Age</td>
          <td><input id="age" name="age"></td>
        </tr>
        <tr>
          <td>Birth</td>
          <td><input id="birth" name="birth"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>

	<h2>${message}</h2>
	<h2>${student1.name}</h2>
	<h2>${student1.hobby}</h2>
	<h2>${student1.phone}</h2>
</body>
</html>