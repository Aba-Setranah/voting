<%-- 
    Document   : viewCandidate
    Created on : Dec 3, 2019, 10:17:19 AM
    Author     : DVondee
--%>
<%@include file="fragment/required.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="fragment/css.jsp" %>
    </head>
    <body>
        <%@include file="fragment/header.jsp" %> 


        <div class="card card-success">
            <div class="card-header">
                <h3 class="card-title">Voter List</h3>
            </div>
            <div class="card-body">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>User Name</th>

                            <th>User Type</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${list}">
                            <tr>
                                <td>${u.firstname}</td>
                                <td>${u.lastname}</td>
                                <td>${u.username}</td>

                                <td>${u.usertype}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="fragment/footer.jsp" %>
    </body>
</html>
