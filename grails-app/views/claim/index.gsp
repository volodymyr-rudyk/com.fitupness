<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 6/17/2014
  Time: 2:57 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
index claims
${sportsmanList.size()}
<g:each in="${sportsmanList}" var="sportsman">
    <p>${sportsman.profile.firstname}</p>
    <g:form action="addClaim">
        <g:submitButton class="btn btn-primary" name="to" value="${sportsman.profile.id}">Claim</g:submitButton>
    </g:form>
</g:each>


list sportsman==<br>
<g:each in="${trainer.sportsmans}" var="sportsman">
    <p>${sportsman.profile.firstname}</p>
    <g:form action="refuseClaim">
        <g:submitButton class="btn btn-danger" name="to" value="${sportsman.profile.id}">Delete claim</g:submitButton>
    </g:form>
</g:each>
</body>
</html>