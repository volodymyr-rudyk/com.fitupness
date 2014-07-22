<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/21/2014
  Time: 1:30 PM
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
            var mapOptions = {
                center: new google.maps.LatLng(49, 27),
                zoom: 3
            };
            map = new google.maps.Map(document.getElementById("map-canvas"),
                    mapOptions);
            console.log('maps init')

            var x = JSON.parse('${clubs.encodeAsJSON()}');
            console.log(x[0].title)

            $.each(x, function (idx, objEvent) {
                var location = new google.maps.LatLng(objEvent.lat, objEvent.lng);
                placeMarker(location, objEvent);
            });

        }

        function placeMarker(location, objEvent) {
            console.log("place marker");
            marker = new google.maps.Marker({
                position: location,
                map: map,
                title: objEvent.title
            });

            attachMarkerInfoWindow(marker, objEvent);
        }

        function attachMarkerInfoWindow(marker, objEvent) {
        var id = '/'  + objEvent.id
        var contentString = '<div id="content">'+
    '<h1 id="firstHeading" class="firstHeading">' +
    objEvent.title + '</h1>'+
    '<div id="bodyContent">'+
    '<p><a href="${createLink(controller: 'sportClub', action: 'view')}'
     + id +'">View</a>' +

    '</p>'+
    '</div>'+

    '</div>';



                        var infowindow = new google.maps.InfoWindow(
                    { content: contentString
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
<g:include view="sportClub/tabs_menu.gsp"/>
<div class="map-canvas" id="map-canvas"/>
</body>
</html>