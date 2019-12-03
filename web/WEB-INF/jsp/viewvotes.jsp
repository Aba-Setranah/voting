<%-- 
    Document   : viewvotes
    Created on : 01-Dec-2019, 15:30:33
    Author     : Selinam
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>view votes!</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Votes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="v" items="${votes}">
                    <tr>
                        <td>${v.name}</td>
                        <td>${v.votes}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
