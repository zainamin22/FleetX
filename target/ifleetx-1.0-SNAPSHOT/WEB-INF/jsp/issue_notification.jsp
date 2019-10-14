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

        <title>Issue Reminders</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">


        <style>
            .org
            {
                color: orangered;

            }

            .bol {
                font-weight: bold;               
            }


            .mar {
                margin-top: 20px;
                margin-bottom: 20px;

            }

            .si {
                font-size: 20px;
            }

            .lef {
                margin-right: 10px;
            }

            .bot {
                margin-bottom: 15px;
            }

            .inp{
                outline: 0;
                border-width: 0 0 2px;
                border-color: gray;
                margin-left: 10px;
                width: 250px;

            }


            .cardy{

                margin-top: 10px;
                height:50px;
            }


            .card-bodyy{
                margin-top: -13px;


            }
            .ii-margin {
                margin-top: 10px;
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


                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Reminders</li>
                    </ol>

                    <div class="row lef">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <p class="si"> <i class="fa fa-bars tex"></i> Service Reminders</p>
                        </div>
                    </div>

                    <!-- Icon Cards-->


                    <div class="row lef bot">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="card  text-center">
                                <div class="card-body">

                                    <form:form modelAttribute="service"  action="issue_service_reminder" method="post">
                                        <div class="form-group row">
                                            <label for="vendor" class="col-sm-3 col-form-label bol text-center">Vendor<span class="required org">*</span></label>
                                            <div class="col-sm-7">
                                                <form:select path="vendor_id" class="form-control" id="vendor" >
                                                    <form:option value="0">Please Select a Vendor</form:option>
                                                    <form:options items="${vendors}" />
                                                </form:select>
                                            </div>
                                        </div>


                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="stitle" class="col-sm-3 col-form-label bol text-center">Service Title<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="service_title" />

                                            </div>
                                        </div>


                                        <hr class="mar"/>



                                        <div class="form-group row">
                                            <label for="desc" class="col-sm-3 col-form-label bol text-center">Service Description<span class="required org">*</span></label>
                                            <div class="col-sm-7 ">
                                                <form:textarea class="form-control" rows="5" id="desc" path="service_description"/>
                                            </div>
                                        </div>

                                        <hr class="mar"/>




                                        <div class="form-group row">
                                            <label for="start" class="col-sm-3 col-form-label bol text-center">Issue Date<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="issue_date" id="serviceDate" />
                                            </div>
                                        </div>


                                        <hr class="mar"/>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <form:input type="submit" path="" class="btn btn-success" value="Issue Notification"/>

                                                </div>

                                            </div>
                                        </div>
                                    </form:form>


                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="row lef">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <p class="si"> <i class="fa fa-bars tex"></i> Driver Renewal Reminders</p>
                        </div>
                    </div>

                    <!-- Icon Cards-->


                    <div class="row lef bot">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="card text-center">
                                <div class="card-body">

                                    <form:form modelAttribute="driverrem"  action="issue_driver_reminder" method="post">
                                        <div class="form-group row">
                                            <label for="vendor" class="col-sm-3 col-form-label bol text-center">Driver<span class="required org">*</span></label>
                                            <div class="col-sm-7">
                                                <form:select path="driver_id" class="form-control" id="driver" >
                                                    <form:option value="0">Please Select a Driver</form:option>
                                                    <form:options items="${drivers}" />

                                                </form:select>
                                            </div>
                                        </div>


                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="renewal_title" class="col-sm-3 col-form-label bol text-center">Renewal Title<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="renewal_title" />

                                            </div>
                                        </div>


                                        <hr class="mar"/>



                                        <div class="form-group row">
                                            <label for="desc" class="col-sm-3 col-form-label bol text-center">Renewal Description<span class="required org">*</span></label>
                                            <div class="col-sm-7 ">
                                                <form:textarea class="form-control" rows="5" id="desc" path="renewal_description" />
                                            </div>
                                        </div>

                                        <hr class="mar"/>




                                        <div class="form-group row">
                                            <label for="start" class="col-sm-3 col-form-label bol text-center">Issue Date<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="issue_date" id="driverDate" />
                                            </div>
                                        </div>


                                        <hr class="mar"/>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <form:input type="submit" path="" class="btn btn-success" value="Issue Notification"/>

                                                </div>

                                            </div>
                                        </div>



                                    </form:form>






                                </div>
                            </div>
                        </div>
                    </div>




                    <div class="row lef">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <p class="si"> <i class="fa fa-bars tex"></i> Vehicle Renewal Reminders</p>
                        </div>
                    </div>

                    <!-- Icon Cards-->


                    <div class="row lef bot">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="card text-center">
                                <div class="card-body">



                                    <form:form modelAttribute="vehiclerem"  action="issue_vehicle_reminder" method="post">

                                        <div class="form-group row">
                                            <label for="vendor" class="col-sm-3 col-form-label bol text-center">Vehicle<span class="required org">*</span></label>
                                            <div class="col-sm-7">
                                                <form:select path="vehicle_id" class="form-control" id="vehicle" >
                                                    <form:option value="0">Please Select a Assigned Vehicle</form:option>
                                                    <form:options items="${vehicles}" />

                                                </form:select>
                                            </div>
                                        </div>


                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="wtitle" class="col-sm-3 col-form-label bol text-center">Renewal Title<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="renewal_title" required="required" />

                                            </div>
                                        </div>


                                        <hr class="mar"/>



                                        <div class="form-group row">
                                            <label for="desc" class="col-sm-3 col-form-label bol text-center">Renewal Description<span class="required org">*</span></label>
                                            <div class="col-sm-7 ">
                                                <form:textarea class="form-control" rows="5" id="desc" path="renewal_description" />
                                            </div>
                                        </div>

                                        <hr class="mar"/>




                                        <div class="form-group row">
                                            <label for="start" class="col-sm-3 col-form-label bol text-center">Issue Date<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="issue_date" id="vehicleDate" />
                                            </div>
                                        </div>


                                        <hr class="mar"/>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <form:input type="submit" path="" class="btn btn-success" value="Issue Notification"/>

                                                </div>

                                            </div>
                                        </div>







                                    </form:form>




                                </div>
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


        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/chart.js/Chart.min.js"></script>
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
        <script src="resources/js/bootstrap-notify.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>


        <script>
            var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
            $('#serviceDate').datepicker({
                uiLibrary: 'bootstrap4',
                iconsLibrary: 'fontawesome',
                minDate: today
            });

            $('#vehicleDate').datepicker({
                uiLibrary: 'bootstrap4',
                iconsLibrary: 'fontawesome',
                minDate: today
            });



            $('#driverDate').datepicker({
                uiLibrary: 'bootstrap4',
                iconsLibrary: 'fontawesome',
                minDate: today
            });



<c:if test="${not empty status}">
     

    
    <c:if test="${status == 'add'}">
    
    
    
    $.notify({
                message: 'Reminder Issued Successfully'
    },{
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
