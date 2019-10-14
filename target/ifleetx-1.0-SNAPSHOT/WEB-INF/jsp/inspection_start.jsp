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

        <title>Inspection</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">


        <style>




            .center {
                margin: auto;
                width: 60%;
                border: 1px solid ;
                padding: 10px;
            }


        </style>

        <script>
            function div_show() {
                document.getElementById("form").style.display = "block";
            }
        </script>


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
                        <li class="breadcrumb-item active">Inspection</li>
                    </ol>


                    <div class="center" >

                        <div class="card text-center" style="margin-bottom:30px;">
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-md-7">
                                        <h2 style="font-size:30px">Inspections</h2>

                                        <p>Ensure your vehicles are safe and compliant. Create inspection checklists, assign
                                            them to specific vehicles and schedule forms for drivers complete using the FleetX app. 
                                            Their responses are captured instantly in your account, alerting you 
                                            to issues and helping to resolve them immediately </p>
                                    </div>



                                    <div class="col-md-4" style="border-style: groove; margin:24px">
                                        <h2 style="font-size:25px;padding:15px" >Get Started</h2>
                                        <button data-toggle="modal" data-target="#myModal"    id="popup" style="margin-bottom: 30px;"   class="btn btn-success " type="button" >&ensp;+Add Inspection Form&ensp;</button>


                                    </div>

                                </div>





                            </div> 
                        </div>
                    </div>


                    <form:form modelAttribute="inspection"  method="post" action="add_inspection">
                        <div class="modal fade" id="myModal">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">New Inspection Form</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>


                                    <div class="modal-body">





                                        <div class="form-group row">
                                            <label for="title" class="col-sm-2 col-form-label">Title <span class="required">*</span></label>
                                            <div class="col-sm-10">
                                                <form:input type="text" class="form-control" path="ititle" id="title" placeholder="Ex:Pre-Trip DVIR" />
                                            </div>
                                        </div>



                                        <div class="form-group row">
                                            <label for="desc" class="col-sm-2 col-form-label">Description <span class="required">*</span></label>
                                            <div class="col-sm-10">

                                                <form:textarea class="form-control" rows="5" id="desc" path="idescription" placeholder="Ex:As required by"/>

                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="template" class="col-sm-2 col-form-label">Template<span class="required">*</span></label>
                                            <div class="col-sm-10">
                                                <form:select path="template" class="form-control" id="template" >
                                                    <form:option value="0">Please Select a Template</form:option>
                                                </form:select>
                                            </div>
                                        </div>




                                        <form:input type="hidden" path="dateCheck" value="0" />





                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <form:input type="submit" class="btn btn-danger" path="" value="Proceed"/>
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
