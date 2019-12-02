<%-- 
    Document   : addvote
    Created on : 01-Dec-2019, 15:27:40
    Author     : Selinam
--%>
<%@include file="fragment/required.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <%@include file="fragment/css.jsp" %>
    </head>
    <body class="hold-transition sidebar-mini">
        <%@include file="fragment/header.jsp" %>
        

        <form action="addvoteaction" method="post">
            <input type="hidden" name="election_id" value="${election.id}"/>
            <input type="hidden" name="user_id" value="${user.id}"/>
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Add Vote!</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                
            <table>

                <tbody>
                    <tr>
                        <td>Election</td>
                        <td>${election.name}</td>
                    </tr>
                    <tr>
                        <td>Candidate</td>
                        <td>
                            <select class="form-control" name="candidate">
                                <c:forEach var="c" items="${candidates}">
                                    <option value="${c.id}">${c.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="btn btn-success" type="submit" value="Vote"/></td>
                    </tr>
                </tbody>
            </table>
              </div>
            </div>
            

        </form>
        <%@include file="fragment/footer.jsp" %>
    </body>
</html>
