<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Issue Details</title>

        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <script src="resources/vendor/jquery/jquery.min.js"></script>


        <link href="resources/css/sb-admin.css" rel="stylesheet">




        <style>

            .card{

                margin-top: 10px;

            }

            .car {
                height:40px;

            }


            .card-body{
                margin-top: -13px;


            }

            .u{

                text-decoration: underline;
                text-underline-position: under;
                text-decoration-color: grey;
                margin-left: 5px;

            }

            .uu{

                font-weight: bold;
                color: gray;


            }


            .fa {
                font-size: 10px;
                margin-right: 5px;

                color: grey;
            }

            .float-right{
                font-size: 18px;
                margin-top: 5px;
                margin-left: 15px;
            }

            .grid-item{
                width: 102.3%;
            }

            .grid {

                margin-bottom: 20px;

            }


            .progress {
                background-color: #07C9A1;
                -webkit-box-shadow: none;
                box-shadow: none;
                height: 25px;
                width: 380px;
            }

            .qwe{
                background: #01B58E;
                margin-left: 1px;
                margin-right: 1px;
                margin-top: 10px;
                margin-bottom: 10px;
                height: 55px;
            }

            .cap {
                text-transform: capitalize;
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






                    <div class="row qwe  text-white card" >
                        <div class="col-md-6" style="margin: 15px 10px 0px 10px;">

                            <span class="cap">${workorder.wstatus}</span><span> (</span><span>${workorder.checked_issues}</span><span> of </span><span>${workorder.total_issues}</span><span>)</span>
                        </div>
                        <div class="col-md-2" style="margin: 15px 10px 0px 0px;">
                            <div class="progress">
                                <div class="progress-bar bg-white" style="width:${workorder.percentage}%;"></div>
                            </div><br>

                        </div>
                    </div>



                    <!-- Icon Cards-->


                    <div class="row">
                        <div class="col-md-12">
                            <div class="card car">
                                <div class="card-body">
                                    <div class="row">

                                        <div class="col-md-11">
                                            <i class="fa fa-play"></i> <span class="u">Odometer Reading:</span>  <span style="color:grey; font-size:12px; ">(Meter Reading)</span>
                                        </div>
                                        <div class="col-md-1">
                                            <span class="bod badge badge-secondary " style="margin-bottom: 10px; margin-left: 10px; font-size: 15px;">${workorder.odometerReading}</span>

                                        </div>

                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>






                    <div class="row">
                        <div class="col-md-12">
                            <div class="card car">
                                <div class="card-body">
                                    <div class="row">

                                        <div class="col-md-11">
                                            <i class="fa fa-play"></i> <span class="u">Issued to:</span>  <span style="color:grey; font-size:12px; ">(Vendor)</span>
                                        </div>
                                        <div class="col-md-1">
                                            <span class="bod badge badge-secondary " style="margin-bottom: 10px;  font-size: 15px;">${workorder.vendor_name}</span>

                                        </div>

                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>



                    <div class="row">
                        <div class="col-md-12">
                            <div class="card car">
                                <div class="card-body">
                                    <div class="row">

                                        <div class="col-md-11">
                                            <i class="fa fa-play"></i> <span class="u">Issued on:</span>  <span style="color:grey; font-size:12px; ">(Vehicle)</span>
                                        </div>
                                        <div class="col-md-1">
                                            <span class="bod badge badge-secondary " style="margin-bottom: 10px; margin-left: 10px; font-size: 15px;">${workorder.vehicle_name}</span>

                                        </div>

                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>





                    <div class="row">
                        <div class="col-md-12">
                            <div class="card bg-info text-white">
                                <div class="card-body">Issues list</div>
                            </div>


                        </div>

                    </div>





                    <c:forEach items="${issues}" var="issue">

                        <div class="card" >
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-md-9">
                                        <span class="uu">#${issue.id}</span> <span class="u">${issue.name}</span>
                                        <p style="margin-left: 30px; margin-top: 10px; color: grey; font-weight: bold; font-size: 14px;">Reported By: <span>${issue.reported_by}</span> </p>
                                        <p style="margin-left: 30px; margin-top: 2px;color: grey; font-weight: bold; font-size: 14px;">Cause: <span>${issue.cause}</span> </p>

                                    </div>
                                    <div class="col-md-3">
                                        <span class="bod badge badge-secondary" style="margin-bottom: 10px; margin-left: 75px; font-size: 16px;">Status:</span>
                                        <span class="bod badge ${issue.color} text-white cap " style="margin-bottom: 10px; margin-left: 10px; font-size: 16px;">${issue.status}</span>

                                    </div>

                                </div>
                            </div> 
                        </div>


                    </c:forEach>



                    <div style="margin-bottom:20px; ">
                    </div>


                </div>





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





        <!-- Logout Modal-->


        <!-- Bootstrap core JavaScript-->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
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
        
                                        window.location.href = '/ifleetx/view_search_result?id=' + item.id + '&category=' + item.category;
                                           
        
                            }

                }
            });



        </script>



    </body>

</html>
