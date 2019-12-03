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
                <h3 class="card-title">Candidate List</h3>
            </div>
            <div class="card-body">
                <table class="table table-bordered">
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
            </div>
        </div>
        <%@include file="fragment/footer.jsp" %>
    </body>
</html>
