<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/14/2014
  Time: 5:48 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
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
    <script type="text/javascript">
        var map;
        var marker;
        var lat;
        var lng;

        function initialize() {

            lat = document.getElementById('lat');
            lng = document.getElementById('lng');

            var mapOptions = {
                center: new google.maps.LatLng(0, 0),
                zoom: 3
            };
            map = new google.maps.Map(document.getElementById("map-canvas"),
                    mapOptions);
            console.log('maps init')


            google.maps.event.addListener(map, 'click', function (event) {
                placeMarker(event.latLng);
                console.log('click' + event.latLng);
            });
        }

        function placeMarker(location) {
            if (marker) {
                marker.setPosition(location);
            } else {
                marker = new google.maps.Marker({
                    position: location,
                    map: map,
                    title: 'marker tt'
                });

                attachMarkerInfoWindow(marker, "Test");

                google.maps.event.addListener(marker, 'dblclick', function (event) {
                    marker.setMap(null);
                    marker = null;
                    lat.value = "";
                    lng.value = "";
                    console.log('rm marker' + event.latLng);
                });

            }
            lat.value = marker.getPosition().lat();
            lng.value = marker.getPosition().lng();
        }

        google.maps.event.addDomListener(window, 'load', initialize);

        function attachMarkerInfoWindow(marker, info) {
            info = "Atata";
            var infowindow = new google.maps.InfoWindow(
                    { content: info/*
                     size: new google.maps.Size(50, 50)*/
                    });
            google.maps.event.addListener(marker, 'click', function () {
                console.log("open info");
                infowindow.open(map, marker);
            });
        }

    </script>
</head>

<body>
<g:if test="${flash.message}">
    <div class="bg-success">${flash.message}</div>
</g:if>
<g:include view="sportClub/tabs_menu.gsp"/>


<div class="row">
    <div class="col-md-8 panel panel-default">
        <div class="panel-body">
            <div class="map-canvas" id="map-canvas"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <g:form role="form" controller="sportClub" action="addClub" method="post">
            <div class="form-group">
                <g:textField class="form-control" type="text" name="title" id="title" placeholder="title"/>
            </div>

            <div class="form-group">
                <g:textField class="form-control" readonly="readonly" type="text" name="lat" id="lat"
                             placeholder="lat"/>
            </div>

            <div class="form-group">
                <g:textField class="form-control" readonly="readonly" type="text" name="lng" id="lng"
                             placeholder="lng"/>
            </div>

            <div class="form-group">
                <g:textArea class="form-control" rows="5" type="text" name="description"/>
            </div>

            <div class="form-group">
                <g:submitButton class="btn btn-primary pull-right" name="submit"/>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>