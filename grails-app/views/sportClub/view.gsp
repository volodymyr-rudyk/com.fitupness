<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/21/2014
  Time: 4:18 PM
--%>

<%@ page import="grails.converters.deep.JSON" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Club</title>

    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <style type="text/css">
    html {
        height: 100%
    }

    body {
        height: 100%;
        margin: 0;
        padding: 0
    }

    #map-canvas {
        height: 400px;
        width: 100%;
    }
    </style>
    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQn-uvugv6VK_XbXY6Glzi71v8O6qzpC0">
    </script>

    <g:javascript>
        var map;
        var marker;

        function initialize() {

            var club = JSON.parse('${club.encodeAsJSON()}');
            var location = new google.maps.LatLng(club.lat, club.lng);
            var mapOptions = {
                center: new google.maps.LatLng(49, 27),
                zoom: 10,
                center:location
            };
            map = new google.maps.Map(document.getElementById("map-canvas"),
                    mapOptions);
            console.log('maps init')
            placeMarker(location, club);
        }

        function placeMarker(location, club) {
            console.log("place marker");
            marker = new google.maps.Marker({
                position: location,
                map: map,
                title: club.title
            });

            attachMarkerInfoWindow(marker, club.title);
        }

        function attachMarkerInfoWindow(marker, info) {
            var infowindow = new google.maps.InfoWindow(
                    { content: info
                    /*
                     size: new google.maps.Size(50, 50)*/
                    });
            google.maps.event.addListener(marker, 'click', function () {
                console.log("open info");
                infowindow.open(map, marker);
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);

    </g:javascript>
</head>

<body>
<div class="row">
    <div class="col-md-8 panel panel-default">
        <div class="panel-body">
            <div class="map-canvas" id="map-canvas"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <div>title = ${club.title}</div>

        <div>lat = ${club.lat}</div>

        <div>lng = ${club.lng}</div>
    </div>
</div>

</body>
</html>