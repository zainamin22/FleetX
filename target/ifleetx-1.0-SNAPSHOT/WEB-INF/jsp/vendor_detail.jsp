<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Vendor Details</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">


        <style>

            .marg {
                margin-top: 20px;
                color: grey;
            }



            .maricn{
                margin-right: 5px;
            }

            table.no-spacing {
                border-spacing:0; /* Removes the cell spacing via CSS */
                border-collapse: collapse;  /* Optional - if you don't want to have double border where cells touch */
            }


            .hea{
                font-weight: bolder;
                color: grey;
                margin-left: -40px;
                margin-right: 10px;    
            }

            .bod{

                font-size: 15px;   

            }




            .card {
                margin-bottom: 15px;
            }


            .hei {
                height: 15px;
            }

            #map{
                height: 325px;  /* The height is 400 pixels */
                width: 100%;
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
                            <a href="#">Vendor List</a>
                        </li>
                        <li class="breadcrumb-item active">${vendor.firstName} ${vendor.lastName}</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="card">
                        <div class="card-body">

                            <div class="row">                    

                                <div class="col-sm-1">
                                    <img src="${vendor.image}" alt="No Picture" class="rounded"  width="80" height="80"> 

                                </div>
                                <div class="col-sm-4">
                                    <h2 class="text-left">${vendor.firstName} ${vendor.lastName}</h2>

                                    <div class="d-flex flex-row marg">

                                        <span class="col-sm-4" style="margin-left: -5px"  ><i class="fa fa-flag maricn" aria-hidden="true"></i>${vendor.status}</span>


                                        <span class="col-sm-4" style="margin-left: -25px"  ><i class="fa fa-car maricn" aria-hidden="true"></i>${vendor.countOfVehicles}</span>






                                    </div>



                                </div>






                            </div>

                        </div>


                    </div>



                    <div class="row" style="margin-top: 20px;">
                        <div class="col-sm-6">

                            <div class="card">
                                <div class="card-header " style="background: white; font-weight: bold;">Vendor Details</div>
                                <div class="card-body">

                                    <div class="text-center hei">
                                        <span class="hea">First Name:</span>  <span class="bod badge badge-info">${vendor.firstName}</span>
                                    </div>

                                    <hr/>




                                    <div class="text-center hei">
                                        <span class="hea">Last Name:</span>  <span class="bod badge badge-info">${vendor.lastName}</span>
                                    </div>

                                    <hr/>



                                    <div class="text-center hei">
                                        <span class="hea">Email:</span>  <span class="bod badge badge-success">${vendor.email}</span>
                                    </div>

                                    <hr/>

                                    <div class="text-center hei">
                                        <span class="hea">CITY:</span>  <span class="bod badge badge-info">${vendor.city}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Country:</span>  <span class="bod badge badge-info">${vendor.country}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Phone Number:</span>  <span class="bod badge badge-info">${vendor.phone}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Address:</span>  <span class="bod badge badge-info"> ${vendor.address}</span>
                                    </div>











                                </div>
                            </div>

                        </div>

                        <div class="col-sm-6">

                            <div class="card">
                                <div class="card-header"  style="background: white; font-weight: bold;">Additional Info</div>

                                <div class="card-body">

                                    <div class="text-center hei">
                                        <span class="hea">Count of Vehicles:</span>  <span class="bod badge badge-secondary">${vendor.countOfVehicles}</span>
                                    </div>

                                    <hr/>

                                    <div class="text-center hei">
                                        <span class="hea">Assigned Work Orders:</span>  <span class="bod badge badge-secondary">${vendor.countOfWorkOrders}</span>
                                    </div>

                                    <hr/>





                                    <div class="text-center hei">
                                        <span class="hea">Assigned Service Entries:</span>  <span class="bod badge badge-secondary">${vendor.countOfServiceEntries}</span>
                                    </div>

                                    <hr/>







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
         <script src="resources/js/jquery.typeahead.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>




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
