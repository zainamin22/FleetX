<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Add Vehicle</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel='stylesheet' href='https://unpkg.com/nprogress@0.2.0/nprogress.css'/>



        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">



        <style>

            .row {
                margin-bottom:30px;
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
                        <li class="breadcrumb-item active">Add Vehicle</li>
                    </ol>





                    <!-- Icon Cards-->


                    <div class="row">
                        <div class="col-md-12">

                            <div class="card">
                                <div class="card-header">
                                    <h5 class="title">Add Vehicle</h5>
                                </div>
                                <div class="card-body">

                                    <form:form modelAttribute="vehicle" id="vehicleForm" enctype="multipart/form-data" action="add_vehicle_process" method="post" >

                                        <div class="row"> 
                                            <div class="col-md-5 pr-md-1">
                                                <div class="form-group">
                                                    <label>Vehicle Name</label>
                                                    <form:input type="text" path="name" class="form-control"  placeholder="Enter the Vehicle Name"/>
                                                </div>
                                            </div>
                                            <div class="col-md-3 px-md-1">
                                                <div class="form-group">
                                                    <label>VIN</label>
                                                    <form:input type="text" path="vin" class="form-control" placeholder="Enter the VIN"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-md-1">
                                                <div class="form-group">
                                                    <label>Vehicle Type</label>
                                                    <form:input type="text" path="type" class="form-control" placeholder="Enter Vehicle Type"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-md-1">
                                                <div class="form-group">
                                                    <label>License Plate Number</label>
                                                    <form:input path="licensePlate" type="text" class="form-control" placeholder="Enter the License Plate Number"/>
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-md-1">
                                                <div class="form-group">
                                                    <label>Car Model</label>
                                                    <form:input path="model" type="text" class="form-control" placeholder="Enter the Car Model"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-4 pr-md-1">
                                                <div class="form-group">
                                                    <label>Registration Province</label>
                                                    <form:input type="text" path="registrationProvince" class="form-control" placeholder="Enter the Registration Province"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 px-md-1">
                                                <div class="form-group">
                                                    <label>Car Model Year</label>
                                                    <form:input type="number" path="year" class="form-control" id='datetimepicker1' placeholder="Enter the Year"/>

                                                </div>


                                            </div>
                                            <div class="col-md-4 pl-md-1">
                                                <div class="form-group">
                                                    <label>Company</label>
                                                    <form:input type="text" class="form-control" path="company" placeholder="Enter Company Name"/>
                                                </div>
                                            </div>
                                        </div>



                                        <div class="row">
                                            <div class="col-md-4 pr-md-1">
                                                <div class="form-group">
                                                    <label>Fuel Type</label>
                                                    <form:input type="text" path="fuelType" class="form-control" placeholder="Enter Fuel Type"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 px-md-1">
                                                <div class="form-group">
                                                    <label>Fuel Tank 1 Capacity</label>
                                                    <form:input type="number" path="fuelTank1Capacity" class="form-control" placeholder="Enter Capacity"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-md-1">
                                                <div class="form-group">
                                                    <label>Fuel Tank 2 Capacity</label>
                                                    <form:input type="number" path="fuelTank2Capacity" class="form-control" placeholder="Enter Capacity"/>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="col-md-4">

                                                <div class="form-group">
                                                    <label for="image">Vehicle Image</label>  
                                                    <form:input type="file" path="image" class="form-control-file" id="image"/>
                                                </div> 
                                            </div>
                                        </div>

                                    </div>

                                    <div class="card-footer">
                                        <form:input type="button" path="" id="vehicleBtn"  class="btn btn-success pull-left btn-lg" value="Add Vehicle"/>
                                    </div>

                                </form:form>  

                            </div>

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


        <script src="https://www.gstatic.com/firebasejs/5.4.1/firebase.js"></script>
        <script>
            // Initialize Firebase
            var config = {
                apiKey: "AIzaSyB7-1f0UkCK7MeX1h_huw2MsIN-k1sLBl4",
                authDomain: "fleetx-1530369852255.firebaseapp.com",
                databaseURL: "https://fleetx-1530369852255.firebaseio.com",
                projectId: "fleetx-1530369852255",
                storageBucket: "fleetx-1530369852255.appspot.com",
                messagingSenderId: "344689335588"
            };
            firebase.initializeApp(config);
        </script>    


        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src='https://unpkg.com/nprogress@0.2.0/nprogress.js'></script>

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



                <c:if test="${status == 'add'}">



            $.notify({
                message: 'Vehicle Added Successfully'
            }, {
                type: 'success'
            });



                </c:if>


            </c:if>





            $('#vehicleBtn').click(function () {

              
                const ref = firebase.storage().ref();
                const file = document.querySelector('#image').files[0];
                if (file){
                     NProgress.start();
                
                const name = (+new Date()) + '-' + file.name;
                const metadata = {
                    contentType: file.type
                };
                const task = ref.child(name).put(file, metadata);
                task
                        .then(snapshot => snapshot.ref.getDownloadURL())
                        .then((url) => {
                            console.log(url);
                             $('<input />').attr('type', 'hidden')
                        .attr('name', "image_url")
                        .attr('value', url)
                        .appendTo('#vehicleForm');
                         NProgress.done();
                            
                            $('form#vehicleForm').submit();
                        })
                        .catch(console.error);

                }
                else {
                    $('form#vehicleForm').submit();
                    
                }
           
            });


            

            






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
