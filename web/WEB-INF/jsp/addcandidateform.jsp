<%-- 
    Document   : addcandidate
    Created on : Dec 3, 2019, 10:05:06 AM
    Author     : DVondee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Candidate</h1>
        <form action="addCandidateAction" method="post">
            Name <input type="text" name="name"/><br><br>
            Party_id <input type="text" name="party"/><br><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>
