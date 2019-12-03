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
        <title>Vote Page</title>
        <%@include file="fragment/css.jsp" %>
    </head>
    <body class="hold-transition sidebar-mini">
        <%@include file="fragment/header.jsp" %>


        <form action="addvoteaction" method="post">
            <input type="hidden" name="election_id" value="${election.id}"/>
            <input type="hidden" name="user_id" value="${user.id}"/>


            <div class="row">
                <!-- left column -->
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Table</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form">
                            <div class="card-body">
                                <table class="table">
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
                            </div>
                            <!-- /.card-body -->

                        </form>
                    </div>
                    <!-- /.card -->


                </div>

                <div class="col-md-6">

                    <!-- Form Element sizes -->
                    <div class="card card-success">
                        <div class="card-header">
                            <h3 class="card-title">Chart</h3>
                        </div>
                        <div class="card-body">

                            <style>
                                canvas {
                                    -moz-user-select: none;
                                    -webkit-user-select: none;
                                    -ms-user-select: none;
                                }
                            </style>
                            <div id="container" style="width: 99%;">
                                <canvas id="canvas"></canvas>
                            </div>
                        </div>
                        <!-- /.card-body -->
                    </div>
                </div>
            </div>
        </form>
        <%@include file="fragment/footer.jsp" %>

        <script src="Chart/Chart.min.js"></script>
        <script src="Chart/utils.js"></script>
        <script>

            var lables = [];
            var values = [];
            <c:forEach var="v" items="${votes}">
            lables.push("${v.name}");
            values.push(${v.votes});
            </c:forEach>

            var color = Chart.helpers.color;
            var barChartData = {
                labels: lables,
                datasets: [{
                        label: 'Totals',
                        backgroundColor: color(window.chartColors.red).alpha(1).rgbString(),
                        borderColor: window.chartColors.grey,
                        borderWidth: 1,
                        data: values
                    }
                ]

            };

            window.onload = function () {
                var ctx = document.getElementById('canvas').getContext('2d');
                window.myBar = new Chart(ctx, {
                    type: 'bar',
                    data: barChartData,
                    options: {
                        responsive: true,
                        legend: {
                            position: 'bottom'
                        },
                        title: {
                            display: true,
                            text: 'Votes'
                        },
                        scales: {
                            yAxes: [{
                                    display: true,
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                        }
                    }
                });
            };
        </script>
    </body>
</html>
