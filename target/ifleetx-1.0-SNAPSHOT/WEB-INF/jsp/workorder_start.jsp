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
        <title>Issue Work Order</title>
        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/tagify.css" rel="stylesheet" type="text/css" />
        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
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
            .card-wrapper-scroll-y {
                display: block;

                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
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
                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Issue Work Order</li>
                    </ol>
                    <!-- Icon Cards-->
                    <div class="row lef">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <p class="si"> <i class="fa fa-bars tex"></i> Work Order Details</p>
                        </div>
                    </div>
                    <form:form modelAttribute="order"  action="work_order_process" method="post" id="orderForm" >
                        <div class="row lef bot">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <div class="card">
                                    <div class="card-body">
                                        
                                        
                                        
                                        <div class="form-group row">
                                            <label for="wtitle" class="col-sm-3 col-form-label bol text-center">Title<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="wtitle" />
                                                
                                            </div>
                                        </div>
                                        
                                        
                                        <hr class="mar"/>
                                        
                                        <div class="form-group row">
                                            <label for="vehicle" class="col-sm-3 col-form-label bol text-center">Vehicle<span class="required org">*</span></label>
                                            <div class="col-sm-7">
                                                <form:select path="vehicle_id" class="form-control" id="vehicle" >
                                                    <form:option value="0">Please Select a Vehicle</form:option>
                                                    <form:options items="${vehicles}" />
                                                </form:select>
                                            </div>
                                        </div>

                                        <hr class="mar"/>

                                        <div class="form-group row">
                                            <label for="vendor" class="col-sm-3 col-form-label bol text-center">Vendor<span class="required org">*</span></label>
                                            <div class="col-sm-7">
                                                <form:select path="vendor_id" class="form-control" id="vehicle" >
                                                    <form:option value="0">Please Select a Vendor</form:option>
                                                    <form:options items="${vendors}" />
                                                </form:select>
                                            </div>
                                        </div>


                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="odometer" class="col-sm-3 col-form-label bol text-center">Odometer<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="number" class="form-control" path="odometerReading" />
                                                <small style="margin-left: 5px;">Meter Reading at the time of the service</small>
                                            </div>
                                        </div>
                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="start" class="col-sm-3 col-form-label bol text-center">Issue Date<span class="required org">*</span></label>
                                            <div class="col-sm-4">
                                                <form:input type="text" class="form-control" path="dateintext" id="startDate" />
                                            </div>
                                        </div>
                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="start" class="col-sm-3 col-form-label bol text-center">Labels</label>
                                            <div class="col-sm-7 ">
                                                <form:input type="text" class="form-control" id="tag" path="wlabels"  />
                                            </div>
                                        </div>
                                        <hr class="mar"/>
                                        <div class="form-group row">
                                            <label for="desc" class="col-sm-3 col-form-label bol text-center">Description</label>
                                            <div class="col-sm-7 ">
                                                <form:textarea class="form-control" rows="5" id="desc" path="description" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row lef">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <p class="si"> <i class="fa fa-bars tex"></i> Service Tasks</p>
                            </div>
                        </div>
                        <div class="row lef bot">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <div class="card-wrapper-scroll-y">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <div class="row bot">
                                                <div class="col-md-1">
                                                    <button type="button" class="btn btn-info" id="serviceButton" >Add a Service Task</button>
                                                </div>
                                            </div>
                                            <ul class="list-group list-group-flush" id="serviceList">

                                            </ul>
                                        </div>
                                    </div>  
                                </div>
                            </div>	
                        </div>
                        <div class="row lef">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <p class="si"> <i class="fa fa-bars tex"></i> Assign Issues</p>
                            </div>
                        </div>
                        <div class="row lef bot">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <div class="card-wrapper-scroll-y">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <div class="row bot">
                                                <div class="col-md-1">
                                                    <button type="button" class="btn btn-info" id="issueButton">Add a Issue</button>
                                                </div>
                                            </div>
                                            <ul class="list-group list-group-flush" id="issueList">

                                            </ul>
                                        </div>
                                    </div>  
                                </div>    
                            </div>	
                        </div>


                        <div class="row lef">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <div class="card">
                                    <div class="card-footer">
                                        <form:input type="submit" path=""  class="btn btn-success w-100 btn-lg" value="Submit Work Order"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr class="mar"/>


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
        <script src="resources/js/bootstrap-notify.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>
        <script src="resources/js/tagify.min.js" type="text/javascript"></script>
        <script>
            var countService = 0;
            var countIssues = 0;
            var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
            $('#startDate').datepicker({
                uiLibrary: 'bootstrap4',
                iconsLibrary: 'fontawesome',
                minDate: today
            });



            var input = document.getElementById("tag");
            tagify = new Tagify(input, {
                callbacks: {
                    add: console.log,
                    remove: console.log
                }
            });


            var myEl = document.getElementById('issueButton');
            myEl.addEventListener('click', function () {
                addIssue();
            }, false);



            var myEl1 = document.getElementById('serviceButton');
            myEl1.addEventListener('click', function () {
                addService();
            }, false);






            function addService() {
                countService++;
                var a = document.getElementById("serviceList");
                var nodes = document.createElement("li");
                nodes.classList.add("list-group-item");
                var html = '<div class="row">' + '<div class="col-md-12">' + '<div class="card cardy">'
                        + '<div class="card-body card-bodyy">' + '<a data-toggle="collapse" href="#collapseExampleS' + countService + '" ><i class="fa fa-play ii-margin"></i></a>'
                        + '<span class="u">' + '<input type="text" class="inp"  placeholder="Enter Service Name" name="serName"  />' + ' </span>'
                        + '<i class="fa fa-trash float-right del ii-margin" id="delService' + countService + '"> </i> ' + ' </div> </div> </div> </div>'
                        + '<div class="collapse" id="collapseExampleS' + countService + '">' + '<div class="card card-body">'
                        + '<div class="form-group row"><label for="" class="col-sm-3 col-form-label bol text-center">Description</label><div class="col-sm-7 "><textarea name="serDescription" class="form-control" rows="5" placeholder=""/></textarea></div></div></div></div>';
                nodes.innerHTML = html;

                a.appendChild(nodes);
                document.getElementById("delService" + countService).addEventListener('click', function () {
                    $(nodes).remove();

                }, false);




            }
            function addIssue() {
                countIssues++;
                var a = document.getElementById("issueList");
                var node = document.createElement("li");
                node.classList.add("list-group-item");
                var html = '<div class="row">' + '<div class="col-md-12">' + '<div class="card cardy">'
                        + '<div class="card-body card-bodyy">' + '<a data-toggle="collapse" href="#collapseExample' + countIssues + '" ><i class="fa fa-play ii-margin"></i></a>'
                        + '<span class="u">' + '<input type="text" class="inp"  placeholder="Enter Issue Name" name="issueName"   />' + ' </span>'
                        + '<i class="fa fa-trash float-right del ii-margin" id="delIssue' + countIssues + '"> </i> ' + ' </div> </div> </div> </div>'
                        + '<div class="collapse" id="collapseExample' + countIssues + '">' + '<div class="card card-body">'
                        + ' <div class="row"><div class="col-md-6 pr-md-1"><div class="form-group">'
                        + '<label class="col-form-label bol">Reported By:</label>' + '<input type="text" class="form-control" name="issueReport" />' + ' </div></div>'
                        + '  <div class="col-md-6 pl-md-1"><div class="form-group"><label class="col-form-label bol">Cause:</label><input type="text" class="form-control" name="issueCause" /></div></div></div>' +
                        '<div class="form-group row"><label for="desc" class="col-sm-3 col-form-label bol text-center">Description</label><div class="col-sm-7 "><textarea class="form-control" rows="5" id="desc" name="issueDescription"  placeholder=""/></textarea></div></div></div></div>';
                node.innerHTML = html;

                a.appendChild(node);
                document.getElementById("delIssue" + countIssues).addEventListener('click', function () {
                    $(node).remove();

                }, false);



            }

            $('#orderForm').submit(function () {

                var serviceTasks = [];
                var issues = [];


                var serNameArr = document.getElementsByName("serName");
                var serDescArr = document.getElementsByName("serDescription");

                for (var i = 0; i < serNameArr.length; i++) {
                    var serName = serNameArr[i].value;
                    var serDesc = serDescArr[i].value;

                    var serv = {name: serName, description: serDesc, status: "uncheck"};
                    serviceTasks.push(serv);
                }

                var serviceJson = JSON.stringify(serviceTasks);

                $('<input />').attr('type', 'hidden')
                        .attr('name', "serviceTasks")
                        .attr('value', serviceJson)
                        .appendTo('#orderForm');




                var issueNameArr = document.getElementsByName("issueName");
                var issueDescArr = document.getElementsByName("issueDescription");
                var issueCauseArr = document.getElementsByName("issueCause");
                var issueReportArr = document.getElementsByName("issueReport");



                for (var i = 0; i < issueNameArr.length; i++) {
                    var ida=i+1;
                    var issueName = issueNameArr[i].value;
                    var issueDesc = issueDescArr[i].value;
                    var issueReport = issueReportArr[i].value;
                    var issueCause = issueCauseArr[i].value;

                    var issu = {name:  issueName, description: issueDesc, status: "unresolved",reported_by:issueReport,cause:issueCause,id:ida};
                    issues.push(issu);
                }
                
                
                 var issueJson = JSON.stringify(issues);

                $('<input />').attr('type', 'hidden')
                        .attr('name', "wissues")
                        .attr('value', issueJson)
                        .appendTo('#orderForm');
                
                return true;
            });


<c:if test="${not empty status}">
     

    
    <c:if test="${status == 'add'}">
    
    
    
    $.notify({
                message: 'WorkOrder Issued Successfully'
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
