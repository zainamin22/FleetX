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

        <title>Profile</title>

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
                        <li class="breadcrumb-item active">Profile</li>
                    </ol>

                    <!-- Icon Cards-->
                    <form:form modelAttribute="admin" enctype="multipart/form-data" action="profile_process" id="profileForm" method="post">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="title">Edit Profile</h5>
                                    </div>
                                    <div class="card-body">

                                        <div class="row">

                                            <div class="col-md-6 px-md-1">
                                                <div class="form-group">
                                                    <label>Email Address</label>
                                                    <form:input type="email" class="form-control" path="email" value="${email}" placeholder="Enter Email Address" />
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-md-1">
                                                <div class="form-group">
                                                    <label>Password</label>
                                                    <form:input type="password" class="form-control" path="password" value="${password}" placeholder="Enter Password"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-md-1">
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <form:input type="text" class="form-control" path="firstName" value="${firstName}" placeholder="Enter First Name" />
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-md-1">
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <form:input type="text" class="form-control" path="lastName" value="${lastName}" placeholder="Enter Last Name"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-7">
                                                <div class="form-group">
                                                    <label>Company Name</label>
                                                    <form:input type="text" class="form-control" path="companyName" value="${companyName}" placeholder="Enter Company Name"/>
                                                </div>
                                            </div>


                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label>Fleet Size</label>
                                                    <form:input type="number" class="form-control" path="fleetSize" value="${fleetSize}" placeholder="Enter Fleet Size"/>
                                                </div>
                                            </div>




                                        </div>
                                        <div class="row">
                                            <div class="col-md-4 pr-md-1">
                                                <div class="form-group">
                                                    <label>City</label>
                                                    <form:input type="text" class="form-control" path="city" value="${city}" placeholder="Enter City"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 px-md-1">
                                                <div class="form-group">
                                                    <label>Country</label>
                                                    <form:input type="text" class="form-control" path="country" value="${country}" placeholder="Enter Country"/>
                                                </div>
                                            </div>
                                            <div class="col-md-4 pl-md-1">
                                                <div class="form-group">
                                                    <label>Phone Number</label>
                                                    <form:input type="number" class="form-control" path="phone" value="${phone}" placeholder="Enter Phone Number"/>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                    <div class="card-footer">
                                        <form:input type="button" id="profileBtn" value="Save" path="" class="btn btn-fill btn-primary"/>
                                    </div>
                                </div>
                            </div>



                            <div class="col-md-4">
                                <div class="card  card-user">
                                    <div class="card-body ">
                                        <p class="card-text">
                                        <div class="author">
                                            <div class="block block-one"></div>
                                            <div class="block block-two"></div>
                                            <div class="block block-three"></div>
                                            <div class="block block-four"></div>
                                            <a href="#">
                                                <img class="avatar rounded-circle"  height="100" width="100" src="<c:out value='${admin.image}'/>" alt="<c:out value='${admin.image}'/>" />
                                                <h5 class="title"><c:out value='${admin.firstName}' /> <c:out value='${admin.lastName}' /></h5>
                                            </a>
                                            <p class="description">
                                                Administrator
                                            </p>
                                        </div>
                                        </p>

                                    </div>
                                    <div class="card-footer ">

                                        <label for="image">Change Profile Image</label>  
                                        <form:input type="file" path="imageData" class="form-control-file" id="image"/>
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
         <script src="resources/js/jquery.typeahead.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>
        
        <script>
            
            $('#profileBtn').click(function () {

               NProgress.start();
                const ref = firebase.storage().ref();
                const file = document.querySelector('#image').files[0];
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
                        .attr('name', "image")
                        .attr('value', url)
                        .appendTo('#profileForm');
                         NProgress.done();
                            
                            $('form#profileForm').submit();
                        })
                        .catch(console.error);


              
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
