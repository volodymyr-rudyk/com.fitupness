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
<div class="row">
    <div class="col-md-3">
        <g:include view="trainer/trainer_menu.gsp"/>
    </div>

    <div class="col-md-8">
        <h2 class="title">Claims</h2>
        <g:if test="${flash.message}">
            <div class="bg-success">${flash.message}</div>
        </g:if>
        <g:each in="${claims}" var="claim">
            <div class="">
                <g:set var="profile" value="claim.from"/>
                from = ${claim.from.firstname} <a href="#">link-${claim.from.id}</a>

                <div>

                    <g:form action="acceptClaim">
                        <g:hiddenField name="from" value="${claim.from.id}"/>
                        <g:submitButton name="accept" class="btn btn-primary" value="Accept"/>
                    </g:form>
                    <g:form action="refuseClaim">
                        <g:hiddenField name="from" value="${claim.from.id}"/>
                        <g:submitButton name="refuse" class="btn btn-danger" value="Refuse"/>
                    </g:form>
                </div>
            </div>
        </g:each>
    </div>
</div>
</body>
</html>