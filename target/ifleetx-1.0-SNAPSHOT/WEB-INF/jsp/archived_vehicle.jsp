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

        <title>Archived Vehicles</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">


        <style>

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
                        <li class="breadcrumb-item active">Archived Vehicle</li>
                    </ol>

                    <!-- Icon Cards-->


                    <div class="card" style="margin-bottom:30px;">
                        <div class="card-body">

                            <table class="table">
                                <thead>
                                    <tr class="row">
                                        <th class="col-sm-1">#</th>
                                        <th class="col-sm-4">Name</th>
                                        <th class="col-sm-1">Status</th>
                                        <th class="col-sm-2" >Type</th>
                                        <th class="col-sm-1" >Fuel Type</th>
                                        <th class="col-sm-1" >Operator</th>
                                        <th class="col-sm-2" ></th>

                                    </tr>
                                </thead>


                                <tbody>

                                    <c:forEach items="${vehicles}" var="vehicle">
                                        <tr class="row">
                                            <td class="col-sm-1 counterCell"></td>
                                            <td class="col-sm-4">
                                                <div class="row">


                                                    <div class="col-sm-2">
                                                        <img src="${vehicle.image_url}" class="rounded"  width="50" height="50"> 

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <h2 class="text-left">${vehicle.name}</h2>
                                                        <p class="tex text-left" style="font-size: 12px;">${vehicle.year} ${vehicle.model}</p>
                                                        <p class="tex text-left" style="font-size: 12px;">${vehicle.vin}</p>
                                                        <p class="tex text-left" style="font-size: 12px;">${vehicle.licensePlate}</p>




                                                    </div>


                                                </div>
                                            </td>
                                            <td class="col-sm-1">${vehicle.status}</td>
                                            <td class="col-sm-2">${vehicle.type}</td>
                                            <td class="col-sm-1">${vehicle.fuelType}</td>
                                            <td class="col-sm-2">${vehicle.operator}</td>
                                            <td class="col-sm-1">
                                                <div class="dropdown">
                                                    <button class="btn btn-success dropdown-toggle" id="menu1" data-toggle="dropdown">
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                                                         <li><a href="view_vehicle_details?id=${vehicle.vehicleId}" style="color: black; margin: 10px;">View Vehicle Profile</a></li>
                                                        <li><a href="unarch_vehicleProcess?id=${vehicle.vehicleId}" style="color: black; margin: 10px;">Unarchive Vehicle</a></li>
                                                        <li><a href="delete_unvehicleProcess?id=${vehicle.vehicleId}" style="color: black; margin: 10px;">Delete Vehicle</a></li>
                                                    </ul>
                                                </div>
                                            </td>
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
        <script src="resources/js/bootstrap-notify.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>

        <script>
            <c:if test="${not empty status}">

                <c:if test="${status == 'assigned'}">



            $.notify({
                message: 'Vehicle Assigned to a driver. Kindly Unassign it First'
            }, {
                type: 'danger'
            });



                </c:if>



                <c:if test="${status == 'successDelete'}">



            $.notify({
                message: 'Vehicle Deleted Successfully'
            }, {
                type: 'success'
            });



                </c:if>


                <c:if test="${status == 'unarchive'}">



            $.notify({
                message: 'Vehicle Unarchived Successfully'
            }, {
                type: 'success'
            });



                </c:if>












            </c:if>

        </script>    

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
