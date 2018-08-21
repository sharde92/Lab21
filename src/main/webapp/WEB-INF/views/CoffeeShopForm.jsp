<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <!-- Form action determines the next URL path -->
        <form action="summary">
            <p>
            Name: <input name="Name" />
            </p>
            <p>
            Age: <input name="Age"/>
           </p>
           <p>
           E-mail: <input type="email" name="Email"/>
            <p>
            Phone Number: <input type="tel" name="Phone_Number"/>
            </p>
            <p>
            <button type="submit">Go!</button>
            </p>
        </form>
</body>
</html>