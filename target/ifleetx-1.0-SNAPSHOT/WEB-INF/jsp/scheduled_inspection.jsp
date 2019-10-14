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

        <title>Scheduled Inspection</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <link href='resources/css/fullcalendar.css' rel='stylesheet' />
        <link href='resources/css/fullcalendar.print.css' rel='stylesheet' media='print' />

        <script src='resources/jquery/jquery-1.10.2.js'></script>
        <script src='resources/jquery/jquery-ui.custom.min.js'></script>

        <script src='resources/js/fullcalendar.js'></script>

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">




        <style>



            #wrap {

                margin: 0 auto;
            }

            #external-events {
                float: left;
                width: 150px;
                padding: 0 10px;
                text-align: left;
            }

            #external-events h4 {
                font-size: 16px;
                margin-top: 0;
                padding-top: 1em;
            }

            .external-event { /* try to mimick the look of a real event */
                margin: 10px 0;
                padding: 2px 4px;
                background: #3366CC;
                color: #fff;
                font-size: .85em;
                cursor: pointer;
            }

            #external-events p {
                margin: 1.5em 0;
                font-size: 11px;
                color: #666;
            }

            #external-events p input {
                margin: 0;
                vertical-align: middle;
            }

            #calendar {
                /* 		float: right; */
                margin-bottom: 15px;
                width: 99%;
                background-color: #FFFFFF;
                border-radius: 6px;
                box-shadow: 0 1px 2px #C3C3C3;
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
                        <li class="breadcrumb-item active">Scheduled Inspection</li>
                    </ol>

                    <!-- Icon Cards-->


                    <div id='wrap'>

                        <div id='calendar'></div>

                        <div style='clear:both'></div>
                    </div>



                    <form:form modelAttribute="inspection" id="checkForm"  method="post" action="add_inspection">
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



                                       






                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <form:input type="submit" class="btn btn-danger" path="" value="Proceed"/>
                                    </div>


                                </div>
                            </div>
                        </div>
                        <form:input type="hidden" path="dateCheck" value="1" />
                        
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



        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>



        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>



        <script>

            $(document).ready(function () {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();



                var calendar = $('#calendar').fullCalendar({
                    header: {
                        left: 'title',
                        right: 'next today'
                    },
                    editable: false,
                    firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
                    selectable: true,
                    defaultView: 'month',

                    axisFormat: 'h:mm',
                    columnFormat: {
                        month: 'ddd', // Mon
                        week: 'ddd d', // Mon 7
                        day: 'dddd M/d', // Monday 9/7
                        agendaDay: 'dddd d'
                    },
                    titleFormat: {
                        month: 'MMMM yyyy', // September 2009
                        week: "MMMM yyyy", // September 2009
                        day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
                    },
                    allDaySlot: false,
                    selectHelper: true,
                    select: function (date) {
                        var d = new Date(date);
                        var n = parseInt(d.getTime());


                      
                        $('#myModal').modal('show');
                        
                        
                         var input = document.createElement('input');
                        input.type = 'hidden';
                        input.name = 'dummyTime';
                        input.value = n;
                        input.setAttribute("id", "well");
                        document.getElementById('checkForm').appendChild(input);





                        calendar.fullCalendar('unselect');
                    }

                });


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
