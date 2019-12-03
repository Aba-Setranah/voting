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
 
        <form action="addvoteaction" method="post">
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
                    </tr>
                    <tr>
                        <td>Candidate</td>
                        <td>
                            <c:forEach var="c" items="${candidates}">
                           ${c.id}
                           ${c.name}
                            </c:forEach>

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
    </body>
</html>
