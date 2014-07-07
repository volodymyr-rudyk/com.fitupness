<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 6/5/2014
  Time: 11:47 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Trainer</title>
</head>

<body>

<div class="row">
    <div class="col-md-3">
        <g:include view="trainer/trainer_menu.gsp"/>
    </div>

    <div class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                Sportsman List
            </div>

            <table class="table table-hover">
                <tr class="info">
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Phone</th>
                </tr>
                <g:each in="${sportsmans}" var="sportsman">
                    <tr>
                        <td>${sportsman.profile.firstname}</td>
                        <td>${sportsman.profile.lastname}</td>
                        <td>${sportsman.profile.phone}</td>
                        <td>
                            <link:profileLink id="${sportsman.profile.id}">View</link:profileLink>
                        </td>

                    </tr>
                </g:each>
            </table>

        </div>
    </div>

</div>

</body>
</html>