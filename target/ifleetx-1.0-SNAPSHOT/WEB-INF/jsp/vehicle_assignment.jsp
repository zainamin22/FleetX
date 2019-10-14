<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <title>Vehicle Assignment</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <style>

            .row {
                margin-bottom:30px;
            }

        </style>

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
                        <li class="breadcrumb-item active">Vehicle Assignment</li>
                    </ol>

                    <!-- Icon Cards-->
                    <form:form modelAttribute="assignment"  action="assign_vehicle_process" method="post" >
                        <div class="card text-center" style="margin-bottom:30px;">
                            <div class="card-header">Assign Vehicle To Driver</div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="driver">Driver Name</label>
                                            <form:select path="driverId" class="form-control"  id="driver">
                                                <form:options items="${drivers}" />
                                            </form:select>




                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="vehicle">Vehicle Name</label>
                                            <form:select path="vehicleId" class="form-control"  id="vehicle">
                                                <form:options items="${vehicles}" />
                                            </form:select>


                                        </div>
                                    </div>
                                </div>







                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <form:input type="submit" path="" class="btn btn-success" value="Assign Vehicle"/>

                                        </div>

                                    </div>
                                </div>


                            </div>

                        </div>

                    </form:form>





                    <form:form modelAttribute="unassignment" action="unassign_vehicle_process"  method="post" >
                        <div class="card text-center" style="margin-bottom:30px;">
                            <div class="card-header">Unassign Vehicle from Driver</div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="driver">Driver Name</label>
                                            <form:select path="driverId" class="form-control"  id="adriver"  onchange="populateVehicle(this.value)" >
                                                <form:option value="0">Please Select a Driver</form:option>
                                                <form:options items="${assigned}" />
                                            </form:select>




                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="vehicle">Vehicle Name</label>
                                            <form:select path="vehicleId" class="form-control"  id="avehicle">

                                            </form:select>


                                        </div>
                                    </div>
                                </div>







                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <form:input type="submit" path="" class="btn btn-success" value="Unassign Vehicle"/>

                                        </div>

                                    </div>
                                </div>


                            </div>

                        </div>

                    </form:form>









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

            function populateVehicle(value) {
                if (value != 0) {

                    fetch('getDriverVehicles/' + value)
                            .then(function (response) {
                                return response.json();
                            })
                            .then(function (myJson) {
                                document.getElementById("avehicle").innerHTML = "";

                                var html = '<option value="' + myJson.vehicleId + '">' + myJson.name + '</option>';
                                ;
                                var d1 = document.getElementById('avehicle');
                                d1.insertAdjacentHTML('beforeend', html);
                            });
                } else {
                    document.getElementById("avehicle").innerHTML = "";
                }

            }



        </script>



        <script src="resources/js/bootstrap-notify.min.js"></script>


        <script>
            <c:if test="${not empty status}">

                <c:if test="${status == 'Fail'}">



            $.notify({
                message: 'Process Failed'
            }, {
                type: 'danger'
            });



                </c:if>



                <c:if test="${status == 'assign'}">



            $.notify({
                message: 'Assignment Complete'
            }, {
                type: 'success'
            });



                </c:if>


                <c:if test="${status == 'unassign'}">



            $.notify({
                message: 'Unassignment Complete'
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
