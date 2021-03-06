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

        <title>Work Orders List</title>

        <style>
            .dot {
                height: 20px;
                width: 20px;
                background-color: lightgreen;
                border-radius: 60%;
                display: inline-block;
            }
            .card {
                margin:10px;
                margin-bottom: 15px;
            }
            
            .cap {
                text-transform: capitalize;
            }
            
            
            .til{
                font-weight: bold;
                margin-left: 5px;
                color: #10707f;
            }
        </style>


    
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">

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
                        <li class="breadcrumb-item active">Work Orders List</li>
                    </ol>

                    <!-- Icon Cards-->


                    <div class="row">
                        
                        <c:forEach items="${workorders}" var="ins">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="cap"> <span style=" background-color: ${ins.statusColor} ;" class="dot"></span>  ${ins.wtitle}</h4>
                                        <p class="cap" style="color:gray">${ins.description}</p>
                                        <p>&nbsp;</p>
                                        <a href="view_servicetask_detail?id=${ins.workOrdersId}">
                                        <span class="til">Service Tasks</span> </a>
                                            <span class="badge badge-secondary float-right m-2 ">${ins.total_servicetask}</span>   
                                     
                                        <hr/>
                                        
                                        <a href="view_issue_detail?id=${ins.workOrdersId}">
                                        <span class="til">Issues</span></a>
                                            <span class="badge badge-secondary float-right m-2 ">${ins.total_issues}</span>   
                                      
                                        <hr/>
                                        
                                            <span class="til">Status</span>
                                            <span class="badge badge-secondary  float-right m-2 cap">${ins.wstatus}</span>
                                        
                                        <hr/>
                                            <span class="til">Last Performed</span>
                                            <span class="badge badge-secondary float-right m-2 cap">${ins.lastPerformedText}</span>    
                  
                                        <hr/>
                                   

                                </div>
                            </div>
                        </div>
                        </c:forEach>
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
            

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>





        <!-- Logout Modal-->


        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/chart.js/Chart.min.js"></script>
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>
 <script src="resources/js/jquery.typeahead.min.js"></script>


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
