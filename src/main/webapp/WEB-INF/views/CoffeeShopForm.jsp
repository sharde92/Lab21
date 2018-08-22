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
        <form action="/summary">
            <p>
            First Name: <input name="firstname" />
            </p>
            <p>
            Last Name: <input name="lastname" />
            </p>
            <p>
            Password: <input name="password" type="password" />
            </p>
            <p>
            Age: <input name="age"/>
           </p>
           <p>
           E-mail: <input type="email" name="email"/>
            <p>
            Phone Number: <input type="tel" name="phone_Number"/>
            </p>
            <p>
            <button type="submit">Go!</button>
            </p>
        </form>
</body>
</html>