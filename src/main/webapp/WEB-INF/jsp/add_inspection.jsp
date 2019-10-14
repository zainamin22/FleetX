<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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

        <title>Add Inspection</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <script src="resources/vendor/jquery/jquery.min.js"></script>

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">




        <style>

            .card{

                margin-top: 10px;
                height:40px;
            }


            .card-body{
                margin-top: -13px;


            }

            .u{

                text-decoration: underline;
                text-underline-position: under;
                text-decoration-color: grey;

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
                        <li class="breadcrumb-item active">Add Inspection</li>
                    </ol>

                    <!-- Icon Cards-->

                    <form:form modelAttribute="inspection" action="inspection_form_process" method="post" >
                        <div class="row" style="margin-bottom: 20px;">


                            <div class="col-md-4">
                                <div class="dropdown">
                                    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown"> + Add Inspection Item</button>
                                    <div class="dropdown-menu" id="add">


                                    </div>

                                </div>
                            </div>

                            <div class="col-md-7">
                            </div>


                            <div class="col-md-1">
                                <button type="button" class="btn btn-info"  data-toggle="modal" data-target="#driverModal">Save</button>
                            </div>


                            <div class="modal fade" id="driverModal" tabindex="-1" role="dialog" aria-labelledby="driverModal" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Assign Inspection to a Driver</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="driver">Driver Name</label>
                                                <form:select path="driverId" class="form-control" id="driver" onchange="populateVehicle(this.value)">
                                                    <form:option value="0">Please Select a Driver</form:option>
                                                    <form:options items="${drivers}" />
                                                </form:select>
                                            </div>

                                            <div class="form-group">
                                                <label for="vehicle">Vehicle Name</label>
                                                <form:select path="vehicleId" class="form-control"  id="vehicle">


                                                </form:select>


                                            </div>


                                        </div>

                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <form:input type="submit" path="" class="btn btn-danger" value="Submit Inspection" />
                                        </div>

                                    </div>
                                </div>
                            </div>



                        </div>



                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-body">
                                        <i class="fa fa-play"></i> <span class="u">Odometer Reading</span>  <span style="color:grey; font-size:12px; ">(Meter Reading)</span>
                                    </div> 
                                </div>
                            </div>
                        </div>



                        <div class="row">


                            <div class="col-md-12">

                                <div class="card bg-secondary text-white">
                                    <div class="card-body">Item Checklist</div>
                                </div>


                            </div>




                        </div>


                        <div class='grid' id="grid">


                            <c:forEach items="${inspectionlist}" var="ins"  varStatus="vs">


                                <div class="row grid-item" id="${ins.key}">
                                    <div class="col-md-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <i class="fa fa-play"  ></i> <span class="u">${ins.value}</span> 
                                                <form:input type="hidden" path="names" value="${ins.value}" /> 
                                                <form:input type="hidden" path="ids" value="${ins.key}" /> 

                                                <i class="fa fa-arrows-alt float-right move" style="cursor: move;" aria-hidden="true"></i>
                                                <i class="fa fa-trash float-right del" onclick="del('${ins.key}', '${ins.value}')" ></i> 







                                            </div> 
                                        </div>
                                    </div>





                                </div>




                            </c:forEach>
                        </div>


                        <form:input type="hidden" path="ititle" value="${inspection.ititle}"/>
                        <form:input type="hidden" path="idescription" value="${inspection.idescription}"/>
                        <form:input type="hidden" path="dummyTime" value="${inspection.dummyTime}"/>
                        <form:input type="hidden" path="dateCheck" value="${inspection.dateCheck}" />

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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/chart.js/Chart.min.js"></script>
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>
        <script src="https://unpkg.com/draggabilly@2/dist/draggabilly.pkgd.min.js"></script>
        <script src="https://unpkg.com/packery@2.1/dist/packery.pkgd.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>


        <script>

                                                    var grid = document.querySelector('.grid');
                                                    var pckry = new Packery('.grid', {
                                                        itemSelector: '.grid-item',
                                                        columnWidth: 700
                                                    });




                                                    pckry.getItemElements().forEach(function (itemElem) {
                                                        var draggie = new Draggabilly(itemElem);
                                                        pckry.bindDraggabillyEvents(draggie);
                                                    });



                                                    function del(id, value) {

                                                        var node = document.createElement("a");


                                                        var textnode = document.createTextNode(value);
                                                        node.appendChild(textnode);
                                                        document.getElementById("add").appendChild(node);
                                                        node.classList.add("dropdown-item");
                                                        node.setAttribute("id", id + 1);


                                                        document.getElementById(id + 1).addEventListener("click", function () {

                                                            add(id, value);
                                                            $(this).remove();


                                                        });


                                                        var a = document.getElementById(id);
                                                        pckry.remove(a);
                                                        pckry.shiftLayout();


                                                    }

                                                    function add(id, value) {

                                                        var node = document.createElement("div");
                                                        node.classList.add("row");
                                                        node.classList.add("grid-item");
                                                        node.setAttribute("id", id);
                                                        var node1 = document.createElement("div");
                                                        node1.classList.add("col-md-12");
                                                        var node2 = document.createElement("div");
                                                        node2.classList.add("card");
                                                        var node3 = document.createElement("div");
                                                        node3.classList.add("card-body");


                                                        var node4 = document.createElement("i");
                                                        node4.classList.add("fa");
                                                        node4.classList.add("fa-play");
                                                        var node5 = document.createElement("span");
                                                        node5.classList.add("u");
                                                        var textnode = document.createTextNode(value);
                                                        node5.appendChild(textnode);
                                                        var node6 = document.createElement("i");
                                                        node6.classList.add("fa");
                                                        node6.classList.add("fa-arrows-alt");
                                                        node6.classList.add("float-right");
                                                        node6.classList.add("move");
                                                        node6.setAttribute("style", "cursor: move;");
                                                        var node7 = document.createElement("i");
                                                        node7.classList.add("fa");
                                                        node7.classList.add("fa-trash");
                                                        node7.classList.add("float-right");
                                                        node7.classList.add("del");

                                                        node7.addEventListener("click", function () {
                                                            del(id, value);
                                                        });


                                                        var input = document.createElement('input');
                                                        input.type = 'hidden';
                                                        input.name = id;
                                                        input.value = 'uncheck';
                                                        node3.appendChild(input);



                                                        var input = document.createElement('input');
                                                        input.type = 'hidden';
                                                        input.name = 'names';
                                                        input.value = value;
                                                        node3.appendChild(input);





                                                        var input = document.createElement('input');
                                                        input.type = 'hidden';
                                                        input.name = 'ids';
                                                        input.value = id;
                                                        node3.appendChild(input);






                                                        node3.append(node4);
                                                        node3.append(node5);
                                                        node3.append(node6);
                                                        node3.append(node7);

                                                        node2.append(node3);
                                                        node1.append(node2);
                                                        node.append(node1);

                                                        grid.appendChild(node);

                                                        pckry.appended(node);

                                                        var draggie = new Draggabilly(node);
                                                        pckry.bindDraggabillyEvents(draggie);
                                                        pckry.shiftLayout();



                                                    }


                                                    function populateVehicle(value) {
                                                        if (value != 0) {

                                                            fetch('getDriverVehicles/' + value)
                                                                    .then(function (response) {
                                                                        return response.json();
                                                                    })
                                                                    .then(function (myJson) {
                                                                        document.getElementById("vehicle").innerHTML = "";

                                                                        var html = '<option value="' + myJson.vehicleId + '">' + myJson.name + '</option>';
                                                                        ;
                                                                        var d1 = document.getElementById('vehicle');
                                                                        d1.insertAdjacentHTML('beforeend', html);
                                                                    });
                                                        } else {
                                                            document.getElementById("vehicle").innerHTML = "";
                                                        }

                                                    }



                                                    function alignGrids(id) {
                                                        var a = document.getElementById(id);
                                                        pckry.fit(a);



                                                    }



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
