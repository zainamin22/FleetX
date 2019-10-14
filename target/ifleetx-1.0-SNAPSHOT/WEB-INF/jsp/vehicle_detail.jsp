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

        <title>Vehicle Details</title>


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


            .customMarker {
                position: absolute;
                cursor: pointer;
                background: #424242;
                width: 50px;
                height: 50px;
                /* -width/2 */
                margin-left: -25px;
                /* -height + arrow */
                margin-top: -55px;
                border-radius: 50%;
                padding: 0px;
            }

            .customMarker:after {
                content: "";
                position: absolute;
                bottom: -10px;
                left: 15px;
                border-width: 10px 10px 0;
                border-style: solid;
                border-color: #424242 transparent;
                display: block;
                width: 0;
            }

            .customMarker img {
                width: 40px;
                height: 40px;
                margin: 5px;
                border-radius: 50%;
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
                            <a href="#">Vehicle List</a>
                        </li>
                        <li class="breadcrumb-item active">${vehicle.name}</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="card">
                        <div class="card-body">

                            <div class="row">                    

                                <div class="col-sm-1">
                                    <img src="${vehicle.image_url}" alt="No Picture" class="rounded"  width="80" height="80"> 

                                </div>
                                <div class="col-sm-4">
                                    <h2 class="text-left">${vehicle.name}</h2>

                                    <div class="d-flex flex-row marg">

                                        <span class="col-sm-4" style="margin-left: -5px"  ><i class="fa fa-flag maricn" aria-hidden="true"></i>${vehicle.status}</span>


                                        <span class="col-sm-4" style="margin-left: -25px"  ><i class="fa fa-car maricn" aria-hidden="true"></i>${vehicle.type}</span>



                                        <span class="col-sm-4" style="margin-left: -40px;"  ><i class="fa fa-car maricn" aria-hidden="true"></i>${vehicle.model}</span>



                                        <span class="col-sm-4"  ><i class="fa fa-id-badge maricn" aria-hidden="true"></i> ${vehicle.operator}</span>


                                    </div>



                                </div>






                            </div>

                        </div>


                    </div>



                    <div class="row" style="margin-top: 20px;">
                        <div class="col-sm-6">

                            <div class="card">
                                <div class="card-header " style="background: white; font-weight: bold;">
                                    Vehicle Details
                                   
                                    <a class="btn btn-success float-right" href="edit_vehicle_details?id=${vehicle.vehicleId}" style="color: white;"> Edit</a>
                                   
                                </div>
                                <div class="card-body">


                                    <div class="text-center hei">
                                        <span class="hea">Name:</span>  <span class="bod badge badge-info">${vehicle.name}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Operator:</span>  <span class="bod badge badge-success">${vehicle.operator}</span>
                                    </div>

                                    <hr/>



                                    <div class="text-center hei">
                                        <span class="hea">VIN:</span>  <span class="bod badge badge-info">${vehicle.vin}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Licence Plate:</span>  <span class="bod badge badge-info">${vehicle.licensePlate}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Vehicle Type:</span>  <span class="bod badge badge-info">${vehicle.type}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Vehicle Model:</span>  <span class="bod badge badge-info">${vehicle.model}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Model Year:</span>  <span class="bod badge badge-info">${vehicle.year}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Company:</span>  <span class="bod badge badge-info">${vehicle.company}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Rgistration Province:</span>  <span class="bod badge badge-info">${vehicle.registrationProvince}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Fuel Type:</span>  <span class="bod badge badge-info">${vehicle.fuelType}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Fuel Tank 1 Capacity:</span>  <span class="bod badge badge-info">${vehicle.fuelTank1Capacity}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Fuel Tank 2 Capacity:</span>  <span class="bod badge badge-info">${vehicle.fuelTank2Capacity}</span>
                                    </div>

                                    <hr/>






                                </div>
                            </div>

                        </div>

                        <div class="col-sm-6">

                            <div class="card">
                                <div class="card-header"  style="background: white; font-weight: bold;">Additional Info</div>

                                <div class="card-body">



                                    <div class="text-center hei">
                                        <span class="hea">Assigned Work Orders:</span>  <span class="bod badge badge-secondary">${vehicle.assigned_workorders}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Assigned Inspections:</span>  <span class="bod badge badge-secondary">${vehicle.assigned_inspection}</span>
                                    </div>

                                    <hr/>


                                    <div class="text-center hei">
                                        <span class="hea">Assigned Service Entries:</span>  <span class="bod badge badge-secondary">${vehicle.assigned_serviceentry}</span>
                                    </div>

                                    <hr/>







                                </div>
                            </div>



                            <div class="card">
                                <div class="card-header"  style="background: white; font-weight: bold;">Location</div>

                                <div class="card-body">


                                    <div id="map"></div>


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
            var map;

            var position = [40.748774, -73.985763];
            function initMap() {

                var latlng = new google.maps.LatLng(position[0], position[1]);
                map = new google.maps.Map(document.getElementById('map'), {
                    center: latlng,
                    zoom: 13,
                    mapTypeControl: false
                });



                CustomMarker.prototype = new google.maps.OverlayView();

                CustomMarker.prototype.draw = function () {
                    // Check if the div has been created.
                    var div = this.div_;
                    if (!div) {
                        // Create a overlay text DIV
                        div = this.div_ = document.createElement('div');
                        // Create the DIV representing our CustomMarker
                        div.className = "customMarker";


                        var img = document.createElement("img");
                        img.src = this.imageSrc;
                        div.appendChild(img);
                        var me = this;
                        google.maps.event.addDomListener(div, "click", function (event) {
                            google.maps.event.trigger(me, "click");
                        });

                        // Then add the overlay to the DOM
                        var panes = this.getPanes();
                        panes.overlayImage.appendChild(div);

                    }

                    // Position the overlay 
                    var point = this.getProjection().fromLatLngToDivPixel(this.latlng_);
                    if (point) {
                        div.style.left = point.x + 'px';
                        div.style.top = point.y + 'px';
                    }

                };

                CustomMarker.prototype.remove = function () {
                    // Check if the overlay was on the map and needs to be removed.
                    if (this.div_) {
                        this.div_.parentNode.removeChild(this.div_);
                        this.div_ = null;
                    }
                };


            <c:if test="${not empty vehicle.status}">



                <c:if test="${vehicle.status == 'Assigned'}">

                var database = firebase.database();

                var dataRef = firebase.database().ref('${id}/${vehicle.driver_id}');

                        dataRef.once("value", function (snap) {
                            var user = snap.val();
                            var latlng = new google.maps.LatLng(user.current_lat, user.current_lon);

                            var marker1;
                            if (user.profile_pic) {

                                marker1 = new CustomMarker(latlng, map, user.profile_pic, user.id);
                            } else {

                                marker1 = new CustomMarker(latlng, map, "http://www.buckinghamandcompany.com.au/wp-content/uploads/2016/03/profile-placeholder.png", user.id);
                            }

                            map.panTo(latlng);



                            var contentString = '<div id="content">' +
                                    '<div id="siteNotice">' +
                                    '</div>' +
                                    '<h1 id="firstHeading" class="firstHeading">' + user.name + '</h1>' +
                                    '<div id="bodyContent">' +
                                    '<p><b>Email: </b>' + user.email +
                                    '</p>' +
                                    '</div>' +
                                    '</div>';

                            var infowindow = new google.maps.InfoWindow({
                                content: contentString
                            });


                            infowindow.setPosition(latlng);
                            infowindow.setOptions({
                                pixelOffset: new google.maps.Size(0, -55)
                            });



                            marker1.addListener('click', function () {
                                infowindow.open(map);

                            });

                        });



                </c:if>


            </c:if>



                    }


                    function CustomMarker(latlng, map, imageSrc, id) {
                        this.latlng_ = latlng;
                        this.imageSrc = imageSrc;
                        this.setMap(map);
                        this.id = id;
                    }



        </script>



        <script src="https://maps.googleapis.com/maps/api/js?v=quarterly&key=AIzaSyCbhC1Ut4XhzjhA5u7gLhoK4KG9KTkthPI&callback=initMap"
        async defer></script>

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
