<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Trips</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="https://developers.google.com/maps/documentation/javascript/demos/demos.css">



        <style>
            .map-control {
                background-color: #fff;
                border: 1px solid #ccc;
                box-shadow: 0 2px 2px rgba(33, 33, 33, 0.4);
                font-family: 'Roboto','sans-serif';
                margin: 10px;
                /* Hide the control initially, to prevent it from appearing
                   before the map loads. */
                display: none;
            }
            /* Display the control once it is inside the map. */
            #map .map-control { display: block; }

            .selector-control {
                font-size: 14px;
                line-height: 30px;
                padding-left: 5px;
                padding-right: 5px;
            }

            #map{
                height: 100%;
            }


            .card-wrapper-scroll-y {
                display: block;
                height: 600px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
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
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Drivers Trip Tracking</li>
                    </ol>

                    <!-- Icon Cards-->



                    <div class="card text-center" style="margin-bottom:30px;">
                        <div class="card-header">Trips</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-4">








                                    <div class="card-wrapper-scroll-y">


                                        <div class="card h-100 ">
                                            <div class="card-header">Drivers List</div>
                                            <div class="card-body">

                                                <ul class="list-group list-group-flush" id="driversList">







                                                </ul>
                                            </div> 
                                        </div>
                                    </div>



















                                </div>
                                <div class="col-md-8">
                                    <div id="style-selector-control"  class="map-control">
                                        <select id="style-selector" class="selector-control">
                                            <option value="default">Default</option>
                                            <option value="silver">Silver</option>
                                            <option value="night">Night mode</option>
                                            <option value="retro" selected="selected">Retro</option>
                                            <option value="hiding">Hide features</option>
                                        </select>
                                    </div>
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
        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>
         <script src="resources/js/jquery.typeahead.min.js"></script>


        <script>
            var map;
            var allMarkers = [];
            var infwindows = [];
            var position = [40.748774, -73.985763];

            function initMap() {

                var latlng = new google.maps.LatLng(position[0], position[1]);
                map = new google.maps.Map(document.getElementById('map'), {
                    center: latlng,
                    zoom: 13,
                    mapTypeControl: false
                });



                var marker = new google.maps.Marker({
                    map: map,
                    animation: google.maps.Animation.DROP,
                    position: latlng
                });



                if (navigator.geolocation)
                    navigator.geolocation.getCurrentPosition(function (pos) {
                        var me = new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
                        marker.setPosition(me);
                        map.panTo(me);

                    }, function (error) {

                    });


                var styleControl = document.getElementById('style-selector-control');
                map.controls[google.maps.ControlPosition.TOP_LEFT].push(styleControl);


                var styleSelector = document.getElementById('style-selector');
                map.setOptions({styles: styles[styleSelector.value]});


                styleSelector.addEventListener('change', function () {
                    map.setOptions({styles: styles[styleSelector.value]});
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




                var list = document.getElementById("driversList");


                var database = firebase.database();

                var dataRef = firebase.database().ref('${id}');




                dataRef.on("child_added", function (snapshot) {
                    var user = snapshot.val();
                    var node = document.createElement("li");
                    node.setAttribute("id", user.id);
                    node.classList.add("list-group-item");
                    var node1 = document.createElement("p");
                    node1.classList.add("tex");
                    var textnode = document.createTextNode(user.name);
                    node1.appendChild(textnode);
                    node.appendChild(node1);
                    list.appendChild(node);




                    var latlng = new google.maps.LatLng(user.current_lat, user.current_lon);

                    var marker1;
                    if (user.profile_pic) {

                        marker1 = new CustomMarker(latlng, map, user.profile_pic, user.id);
                    } else {

                        marker1 = new CustomMarker(latlng, map, "http://www.buckinghamandcompany.com.au/wp-content/uploads/2016/03/profile-placeholder.png", user.id);
                    }




                    allMarkers.push(marker1);



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




                    infwindows.push(infowindow);



                    marker1.addListener('click', function () {
                        infowindow.open(map);

                    });




                    node.addEventListener("click", function () {
                        map.panTo(latlng);
                    });




                });



                dataRef.on("child_changed", function (snapshot) {
                    var user = snapshot.val();


                    for (var i = 0; i < allMarkers.length; i++) {
                        if (allMarkers[i].id === user.id) {
                            var latlng = new google.maps.LatLng(user.current_lat, user.current_lon);
                            allMarkers[i].setMap(null);
                            allMarkers[i] = new CustomMarker(latlng, map, user.profile_pic, user.id);
                            infwindows[i].setPosition(latlng);

                            allMarkers[i].addListener('click', function () {
                                infwindows[i].open(map);

                            });


                            var node = document.getElementById(user.id);

                            node.addEventListener("click", function () {
                                map.panTo(latlng);
                            });


                            break;
                        }
                    }



                });





            }

            var styles = {
                default: null,
                silver: [
                    {
                        elementType: 'geometry',
                        stylers: [{color: '#f5f5f5'}]
                    },
                    {
                        elementType: 'labels.icon',
                        stylers: [{visibility: 'off'}]
                    },
                    {
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#616161'}]
                    },
                    {
                        elementType: 'labels.text.stroke',
                        stylers: [{color: '#f5f5f5'}]
                    },
                    {
                        featureType: 'administrative.land_parcel',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#bdbdbd'}]
                    },
                    {
                        featureType: 'poi',
                        elementType: 'geometry',
                        stylers: [{color: '#eeeeee'}]
                    },
                    {
                        featureType: 'poi',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#757575'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'geometry',
                        stylers: [{color: '#e5e5e5'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#9e9e9e'}]
                    },
                    {
                        featureType: 'road',
                        elementType: 'geometry',
                        stylers: [{color: '#ffffff'}]
                    },
                    {
                        featureType: 'road.arterial',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#757575'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'geometry',
                        stylers: [{color: '#dadada'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#616161'}]
                    },
                    {
                        featureType: 'road.local',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#9e9e9e'}]
                    },
                    {
                        featureType: 'transit.line',
                        elementType: 'geometry',
                        stylers: [{color: '#e5e5e5'}]
                    },
                    {
                        featureType: 'transit.station',
                        elementType: 'geometry',
                        stylers: [{color: '#eeeeee'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'geometry',
                        stylers: [{color: '#c9c9c9'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#9e9e9e'}]
                    }
                ],

                night: [
                    {elementType: 'geometry', stylers: [{color: '#242f3e'}]},
                    {elementType: 'labels.text.stroke', stylers: [{color: '#242f3e'}]},
                    {elementType: 'labels.text.fill', stylers: [{color: '#746855'}]},
                    {
                        featureType: 'administrative.locality',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#d59563'}]
                    },
                    {
                        featureType: 'poi',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#d59563'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'geometry',
                        stylers: [{color: '#263c3f'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#6b9a76'}]
                    },
                    {
                        featureType: 'road',
                        elementType: 'geometry',
                        stylers: [{color: '#38414e'}]
                    },
                    {
                        featureType: 'road',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#212a37'}]
                    },
                    {
                        featureType: 'road',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#9ca5b3'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'geometry',
                        stylers: [{color: '#746855'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#1f2835'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#f3d19c'}]
                    },
                    {
                        featureType: 'transit',
                        elementType: 'geometry',
                        stylers: [{color: '#2f3948'}]
                    },
                    {
                        featureType: 'transit.station',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#d59563'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'geometry',
                        stylers: [{color: '#17263c'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#515c6d'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'labels.text.stroke',
                        stylers: [{color: '#17263c'}]
                    }
                ],

                retro: [
                    {elementType: 'geometry', stylers: [{color: '#ebe3cd'}]},
                    {elementType: 'labels.text.fill', stylers: [{color: '#523735'}]},
                    {elementType: 'labels.text.stroke', stylers: [{color: '#f5f1e6'}]},
                    {
                        featureType: 'administrative',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#c9b2a6'}]
                    },
                    {
                        featureType: 'administrative.land_parcel',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#dcd2be'}]
                    },
                    {
                        featureType: 'administrative.land_parcel',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#ae9e90'}]
                    },
                    {
                        featureType: 'landscape.natural',
                        elementType: 'geometry',
                        stylers: [{color: '#dfd2ae'}]
                    },
                    {
                        featureType: 'poi',
                        elementType: 'geometry',
                        stylers: [{color: '#dfd2ae'}]
                    },
                    {
                        featureType: 'poi',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#93817c'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'geometry.fill',
                        stylers: [{color: '#a5b076'}]
                    },
                    {
                        featureType: 'poi.park',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#447530'}]
                    },
                    {
                        featureType: 'road',
                        elementType: 'geometry',
                        stylers: [{color: '#f5f1e6'}]
                    },
                    {
                        featureType: 'road.arterial',
                        elementType: 'geometry',
                        stylers: [{color: '#fdfcf8'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'geometry',
                        stylers: [{color: '#f8c967'}]
                    },
                    {
                        featureType: 'road.highway',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#e9bc62'}]
                    },
                    {
                        featureType: 'road.highway.controlled_access',
                        elementType: 'geometry',
                        stylers: [{color: '#e98d58'}]
                    },
                    {
                        featureType: 'road.highway.controlled_access',
                        elementType: 'geometry.stroke',
                        stylers: [{color: '#db8555'}]
                    },
                    {
                        featureType: 'road.local',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#806b63'}]
                    },
                    {
                        featureType: 'transit.line',
                        elementType: 'geometry',
                        stylers: [{color: '#dfd2ae'}]
                    },
                    {
                        featureType: 'transit.line',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#8f7d77'}]
                    },
                    {
                        featureType: 'transit.line',
                        elementType: 'labels.text.stroke',
                        stylers: [{color: '#ebe3cd'}]
                    },
                    {
                        featureType: 'transit.station',
                        elementType: 'geometry',
                        stylers: [{color: '#dfd2ae'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'geometry.fill',
                        stylers: [{color: '#b9d3c2'}]
                    },
                    {
                        featureType: 'water',
                        elementType: 'labels.text.fill',
                        stylers: [{color: '#92998d'}]
                    }
                ],

                hiding: [
                    {
                        featureType: 'poi.business',
                        stylers: [{visibility: 'off'}]
                    },
                    {
                        featureType: 'transit',
                        elementType: 'labels.icon',
                        stylers: [{visibility: 'off'}]
                    }
                ]
            };

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
