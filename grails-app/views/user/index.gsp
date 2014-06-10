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
            <a href="${createLink(action: 'index2')}" class="list-group-item">Programs2</a>
            <a href="http://google.com" class="list-group-item">asas</a>
            <a href="${createLink(controller: 'program')}" class="list-group-item">PROGRAM</a>
            <li class="list-group-item">item<span class="glyphicon glyphicon-chevron-right"></span></li>
        </ul>
        <ul class="list-group">
            <a href="#" class="list-group-item">asas</a>
            <a href="#" class="list-group-item">asas</a>
            <a href="#" class="list-group-item">asas</a>
            <a href="#" class="list-group-item">asas</a>
        </ul>

        <ul class="list-group">
            <li class="list-group-item">item<span class="glyphicon glyphicon-certificate pull-right"></span></li>
        </ul>
        .col-md-8

    </div>

    <div class="col-md-8">.col-md-4</div>
</div>


User profile
%{--${profile?.firstname}--}%
name =
${sportsman?.profile?.firstname},
trainer =

<br>${sportsman?.trainer?.profile?.firstname}

<br>
rating = ${sportsman?.rating?.points}<br>
profiletype = ${sportsman?.profile?.profileType?.type}

<a class="btn btn-primary" href="${createLink(controller: 'program')}">My Programs</a>
</body>
</html>