<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Dashboard</title>





        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">


        <style>

            .row {
                margin-bottom:10px;



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
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="row">

                        <div class="col-md-4">

                            <div class="card  text-center ">
                                <div class="card-header">Vehicles</div>
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.unassignedVehicles}</p>
                                            <p class="text-center tex">Unassigned</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.assignedVehicles}</p>
                                            <p class="text-center tex">Assigned</p>
                                        </div>
                                    </div>





                                </div> 
                            </div>


                        </div>
                        <div class="col-md-4">

                            <div class="card text-center ">
                                <div class="card-header">Drivers</div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.unassignedDrivers}</p>
                                            <p class="text-center tex">Unassigned</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.assignedDrivers}</p>
                                            <p class="text-center tex">Assigned</p>
                                        </div>
                                    </div>
                                </div> 
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="card  text-center ">
                                <div class="card-header">Vendors</div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.unassignedVendor}</p>
                                            <p class="text-center tex">Unassigned</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.assignedVendor}</p>
                                            <p class="text-center tex">Assigned</p>
                                        </div>
                                    </div>
                                </div> 
                            </div>

                        </div>







                    </div>



                    <div class="row">

                        <div class="col-md-4">

                            <div class="card  text-center ">
                                <div class="card-header">Service Reminders</div>
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.assignedServiceReminders}</p>
                                            <p class="text-center tex">Issued</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.overdueServiceReminders}</p>
                                            <p class="text-center tex">Overdue</p>
                                        </div>
                                    </div>





                                </div> 
                            </div>


                        </div>
                        <div class="col-md-4">

                            <div class="card text-center ">
                                <div class="card-header">Driver Renewal Reminders</div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.assignedDriverReminders}</p>
                                            <p class="text-center tex">Issued</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.overdueDriverReminders}</p>
                                            <p class="text-center tex">Overdue</p>
                                        </div>
                                    </div>
                                </div> 
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="card  text-center ">
                                <div class="card-header">Vehicle Renewal Reminders</div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="text-center badge1">${info.assignedVehicleReminders}</p>
                                            <p class="text-center tex">Issued</p>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-center badge2">${info.overdueVehicleReminders}</p>
                                            <p class="text-center tex">Overdue</p>
                                        </div>
                                    </div>
                                </div> 
                            </div>

                        </div>







                    </div>







                    <div class="row">

                        <div class="col-md-6" >
                            <div class="card h-100 text-center ">
                                <div class="card-header">Inspections</div>
                                <div class="card-body">

                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">
                                            <p class="tex" style="float: left;">Started</p>
                                            <p class="wbadge1"  style="float: right;">${info.startedInspection}</p>

                                        </li>
                                        <li class="list-group-item">


                                            <p class="tex"  style="float: left;">In Progress</p>
                                            <p class="wbadge2"  style="float: right;">${info.inProgressInspection}</p>

                                        </li>
                                        <li class="list-group-item">

                                            <p class="tex"  style="float: left;">Completed</p>
                                            <p class="wbadge3"  style="float: right;">${info.completedInspection}</p>



                                        </li>
                                    </ul>
                                </div> 
                            </div>

                        </div>


                        <div class="col-md-6">
                            <div class="card h-100 text-center marg">
                                <div class="card-header">Work Orders</div>
                                <div class="card-body">

                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">
                                            <p class="tex" style="float: left;">Started</p>
                                            <p class="wbadge1"  style="float: right;">${info.startedWorkOrders}</p>

                                        </li>
                                        <li class="list-group-item">


                                            <p class="tex"  style="float: left;">In Progress</p>
                                            <p class="wbadge2"  style="float: right;">${info.inProgressWorkOrders}</p>

                                        </li>
                                        <li class="list-group-item">

                                            <p class="tex"  style="float: left;">Completed</p>
                                            <p class="wbadge3"  style="float: right;">${info.completedWorkOrders}</p>



                                        </li>
                                    </ul>
                                </div> 
                            </div>

                        </div>











                    </div>




























                    <!-- Area Chart Example-->





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





        <!-- Logout Modal-->


        <!-- Bootstrap core JavaScript-->



        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="resources/js/jquery.typeahead.min.js"></script>


        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/chart.js/Chart.min.js"></script>
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="resources/js/demo/datatables-demo.js"></script>
        <script src="resources/js/demo/chart-area-demo.js"></script>


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
