<%-- 
    Document   : adduserform
    Created on : Dec 4, 2019, 11:02:13 AM
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
        <h1>Add User</h1>
        <form action="addUserAction" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" class="form-control" name="firstname" required=""/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" class="form-control" name="lastname" required=""/></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" class="form-control" name="username" required=""/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" class="form-control" name="password" required=""/></td>
                    </tr>
                    <tr>
                        <td>User type</td>
                        <td><select name="usertype" required="">
                                <option></option>
                                <option value="voter"> voter</option>
                                <option value="admin">admin</option>
                            </select></td>

                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="btn btn-success" value="ADD"></td>
                    </tr>


                </tbody>
            </table>
        </form>
    </body>
</html>
