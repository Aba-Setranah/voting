<%-- 
    Document   : adminlogin
    Created on : 03-Dec-2019, 10:57:33
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
        <h1>Admin Login!</h1>
        <form action="admincheck" method="post"> 
            <table border="1">
                <tbody>
                    <tr>
                        <td>Admin ID</td>
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
