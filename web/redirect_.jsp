<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>--%>

<%-- 
    Document   : voterlogin
    Created on : 02-Dec-2019, 22:55:06
    Author     : Selinam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Voter Login!</h1>
        <form action="usercheck" method="post"> 
            <table border="1">
                <tbody>
                    <tr>
                        <td>Voter ID</td>
                        <td><input type="text" name="id"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <td><input type="submit" value="submit"/></td>
                        
                </tbody>
            </table>
        </form>
    </body>
</html>

