<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Leaderboard</title>

     
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

      
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">


        <link href="resources/css/sb-admin.css" rel="stylesheet">



        <style>


            .badge1 {
                position:absolute;
                margin-left: 28px;



            }
            
            
            .red.badge1 {
               
                background:red;


            }
            
            
            
            .green.badge1 {
               
                background:green;


            }
            
            
            .gold.badge1 {
               
                background:gold;


            }
            
            
            
            
            

            .badge1[data-badge]:after  {
                content:attr(data-badge);
                position:absolute;  
                font-size:.7em;
                background:inherit;
                color:white;

                width:50px;height:50px;

                text-align:center;
                line-height:45px;
                border-radius:100%;
                box-shadow:0 0 1px #333;
            }
            
            
            tr {
                line-height: 30px;
            }

            .table {
                margin-left: 10px;
                margin-right: 10px;
                counter-reset: tableCount;

            }


            .counterCell:before {              
                content: counter(tableCount); 
                counter-increment: tableCount; 
            }


        </style>
            
            
            
     






    </head>

    <body id="page-top">

        <%@ include file="nav.jspf" %>  


        <div id="wrapper">

            <!-- Sidebar -->
            <%@ include file="nav_right.jspf" %>   

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Driver Scoreboard</li>
                    </ol>

                    <!-- Icon Cards-->



                    <div class="card text-center" style="margin-bottom:30px;">

                        <div class="card-body">

                            <table class="table">
                                <thead>
                                    <tr class="row">
                                        <th class="col-sm-1">Rank</th>
                                        <th class="col-sm-2">Driver</th>
                                        <th class="col-sm-2"></th>
                                        <th class="col-sm-3">Duration</th>
                                        <th class="col-sm-1"></th>
                                        <th class="col-sm-3"  >Score</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${drivers}" var="driver">
                                    
                                    <tr class="row">
                                        <td class="col-sm-1 counterCell"></td>
                                        <td class="col-sm-2"><img href="" src="${driver.image}" class="rounded-circle" alt="Cinque Terre" width="55" height="55">&nbsp; ${driver.firstName} ${driver.lastName}</td>
                                        <td class="col-sm-2"></td>  
                                        <td class="col-sm-3">${driver.totalDistanceCovered} <span> miles</span> <pre><span style="color:green">${driver.totalTrips} Trips</span></pre></td>
                                    
                                        <td class="col-sm-4"><a href="" class="badge1 ${driver.colour}" data-badge="${driver.averageScore}"></a></td>

                                    </tr>
                                   
                                  </c:forEach>

                                </tbody>

                            </table>


























                        </div>
                    </div>


                </div>
                <!-- /.container-fluid -->




                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © FleetX 2018</span>
                        </div>
                    </div>
                </footer>

                <!-- Sticky Footer -->







            </div>
            <!-- /.content-wrapper -->






        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>





     


        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/chart.js/Chart.min.js"></script>
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>

 <script>

            typeof $.typeahead === 'function' && $.typeahead({
                input: ".js-typeahead",
                minLength: 0,
                maxItem: 9,
                maxItemPerGroup: 3,
                order: "asc",
                hint: true,
                group: {
                    key: "category"
                },
                emptyTemplate: 'no result for {{query}}',
                groupOrder: ["Vehicle", "Driver", "Vendor"],
                display: ["name"],
                correlativeTemplate: true,
                template: '<div class="row">' +
                        '<div class="col-sm-2"><img src="{{img}}" class="rounded-circle"  width="55" height="55"></div>' +
                        '<div class="col-sm-4">{{name}}</div>' +
                        '</div>',
                source: {
                    result: {
                        url: "/ifleetx/getSearchResults"
                    }
                },
                debug: true,

                callback: {
                            onClickAfter: function (node, a, item, event) {
 
                                    event.preventDefault();
 
                                        window.location.href='/ifleetx/view_search_result?id='+item.id+'&category='+item.category;
                                    
 
                            }

                }
            });



        </script>




    </body>

</html>
