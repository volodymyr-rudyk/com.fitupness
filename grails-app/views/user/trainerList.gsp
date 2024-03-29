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
        <g:include view="user/user_menu.gsp"/>
    </div>

    <div class="col-md-8">
        <h2>Trainer list</h2>

        <g:each in="${trainers}" var="trainer">
            <div class="">
                name = ${trainer.profile.firstname}
                <g:if test="${!sportsman.trainer && !claim}">**
                    <g:form action="addClaim" method="post">
                        <g:hiddenField name="to" value="${trainer.profile.id}"/>
                        <g:submitButton name="claim" value="Send claim"/>
                    </g:form>
                </g:if>
                <g:if test="${claim?.to?.id == trainer.profile.id}">
                    <span class="bg-info small">Claim pending</span>
                </g:if>
                <g:if test="${trainer.id == sportsman.trainer?.id}">
                    <span class="bg-info small">Claim Accepted</span>
                </g:if>
            </div>
        </g:each>
    </div>
</div>
</body>
</html>