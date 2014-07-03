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

        <ul class="list-group">
            <a href="${createLink(controller: 'trainer')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Profile</a>
            <a href="${createLink(controller: 'program')}" class="list-group-item
            <g:if test="${controllerName == 'program' && actionName == ''}">active</g:if>">Programs</a>
            <a href="${createLink(controller: 'trainer', action: 'sportsmanList')}" class="list-group-item
            <g:if test="${controllerName == 'trainer' && actionName == 'sportsmanList'}">active</g:if>">Sportsman</a>
            <a href="${createLink(action: 'claimsList')}" class="list-group-item
            <g:if test="${actionName == 'claimsList'}">active</g:if>">
                <g:if test="${claimsCount > 0}"><span class="badge">${claimsCount}</span></g:if>Claims</a>
        </ul>

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

                    </tr>
                </g:each>
            </table>

        </div>
    </div>

</div>

</body>
</html>