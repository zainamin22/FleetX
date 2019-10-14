<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Trip List</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">

        <style>

            .card {
                margin:10px;
                margin-bottom: 15px;
            }

            .cap {
                text-transform: capitalize;
            }


            .tiltt{
                font-weight: bold;
                color: #10707f;

            }


            .badge1 {
                margin-right: 30px;

                margin-top: -7px;



            }


            .red.badge1 {

                background:red;


            }



            .green.badge1 {

                background:green;


            }


            .gold.badge1 {

                background:gold;


            }






            .badge1[data-badge]:after  {
                content:attr(data-badge);
                position:absolute;  
                font-size:.5em;
                background:inherit;
                color:white;

                width:40px;height:40px;

                text-align:center;
                line-height:37px;
                border-radius:100%;
                box-shadow:0 0 1px #333;
            }


            .hea{
                font-weight: bolder;
                color: grey;

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


            .map{
                height: 250px;
            }
            
            .teq {
                font-weight: lighter;
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
                            <a href="#">${driver.firstName} ${driver.lastName}</a>
                        </li>
                        <li class="breadcrumb-item active">Trip Reports</li>
                    </ol>

                    <!-- Icon Cards-->




                    <div class="row">

                        <c:forEach items="${trips}" var="trip">
                            <div class="col-md-4">
                                <div class="card">

                                    <div class="card-header">
                                        <span class="tiltt"> Trip Id # ${trip.tripId} </span>

                                        <a href="" class="float-right badge1 ${trip.colour}" data-badge="${trip.averageScore}"></a>
                                    </div>

                                    <div class="card-body">

                                          
                                        <i class="fa fa-clock hea" aria-hidden="true"></i> <span class="teq">${trip.timeText}</span>
                                           
                                         <hr/>
                                         
                                          <i class="fa fa-calendar hea" aria-hidden="true"></i> <span class="teq">${trip.dateText}</span>
                                          <hr/>
                                        
                                                <span class="hea">Start:</span> 
                                                
                                           
                                           
                                                
                                                  <span class="teq" id="start${trip.tripId}"></span>
                                            
                                           
                                

                                        <hr/>


                                        <div id="map${trip.tripId}" class="map"></div>   


                                        <hr/>


                                     
                                            <span class="hea">End:</span>  <span class="teq" id="end${trip.tripId}"></span>

                                        

                                        <hr/>



                                    </div>
                                </div>
                            </div>
                        </c:forEach>
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
            var position = [40.748774, -73.985763];
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
        
                                        window.location.href = '/ifleetx/view_search_result?id=' + item.id + '&category=' + item.category;
                                           
        
                            }

                }
            });




            function initMap() {


            <c:forEach items="${trips}" var="trip">


                var latlng = new google.maps.LatLng(position[0], position[1]);
                var map = new google.maps.Map(document.getElementById('map${trip.tripId}'), {
                    center: latlng,
                    zoom: 13,
                    mapTypeControl: false
                });
                var start = new google.maps.LatLng(${trip.startingLat},${trip.startingLon});
                var end = new google.maps.LatLng(${trip.endingLat}, ${trip.endingLon});

                setRoute(start, end, map);
                
                var st=document.getElementById('start${trip.tripId}');
                var en=document.getElementById('end${trip.tripId}');
                
                
                setAddress(start,st);
                setAddress(end,en);


            </c:forEach>






            }



            function setRoute(start, end, map) {

                var directionsService = new google.maps.DirectionsService();
                var directionsDisplay = new google.maps.DirectionsRenderer();
                directionsDisplay.setMap(map);

                var bounds = new google.maps.LatLngBounds();
                bounds.extend(start);
                bounds.extend(end);
                map.fitBounds(bounds);
                var request = {
                    origin: start,
                    destination: end,
                    travelMode: google.maps.TravelMode.DRIVING
                };

                directionsService.route(request, function (response, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(response);
                        directionsDisplay.setMap(map);
                    } else {
                        alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
                    }
                });





            }


            function setAddress(latlng, element) {
                var geocoder = new google.maps.Geocoder;

                geocoder.geocode({'location': latlng}, function (results, status) {
                    if (status === 'OK') {
                        if (results[0]) {
                            element.innerHTML=results[0].formatted_address;

                        }
                        else {
                               element.innerHTML='Address not Found';
                        }
                    }
                    else {
                        element.innerHTML='Address not Found';  
                    }
                });



            }







        </script>


        <script src="https://maps.googleapis.com/maps/api/js?v=quarterly&key=AIzaSyCbhC1Ut4XhzjhA5u7gLhoK4KG9KTkthPI&callback=initMap"
        async defer></script>


    </body>

</html>
