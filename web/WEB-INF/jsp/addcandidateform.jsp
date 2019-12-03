<%-- 
    Document   : addcandidate
    Created on : Dec 3, 2019, 10:05:06 AM
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
        <h1>Add Candidate</h1>
        <form action="addCandidateAction" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" class="form-control" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Party_id</td>
                        <td><input type="text" class="form-control" name="party"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="btn btn-success" value="ADD"></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
        <%@include file="fragment/footer.jsp" %>
    </body>
</html>
