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
    <title>User</title>
</head>

<body>

<div class="row">
    <div class="col-md-3">

        <ul class="list-group">
            <a href="${createLink(controller: 'user')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Profile</a>
            <a href="${createLink(controller: 'program')}" class="list-group-item">PROGRAM</a>
            <a href="${createLink(action: 'trainerList')}" class="list-group-item">TrainerList</a>
        </ul>

    </div>

    <div class="col-md-8">
        <h2>Profile data</h2>

        <div>firstname : ${sportsman.profile.firstname}</div>

        <div>lastname : ${sportsman.profile.lastname}</div>

        <div>address : ${sportsman.profile.address?.country?.country},
            ${sportsman.profile.address?.city?.city}</div>

        <div>body weight : ${sportsman.profile.body?.weight}</div>

        <div>profile type : ${sportsman.profile.profileType?.type}</div>

        <div>trainer : ${sportsman?.trainer?.profile?.firstname}</div>

        <div>rating : ${sportsman?.rating?.points}</div>

    </div>
</div>

</body>
</html>