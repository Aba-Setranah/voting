<%-- 
    Document   : viewCandidate
    Created on : Dec 3, 2019, 10:17:19 AM
    Author     : DVondee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Candidate List</h1>
        
        <table border="1" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>name</th>
                
            </tr>
            <c:forEach var="ca" items="${list}">
            <tr>
                <td>${ca.id}</td>
                <td>${ca.name}</td>
                
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
