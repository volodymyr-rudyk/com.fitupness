<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 28-Apr-14
  Time: 6:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
    <title>Signup</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="container" style="margin-bottom: 85px">

    <div class="row col-md-6 col-md-offset-3 form-group">
        <h3 class="center">Create new Profile</h3>
        <g:form action="doSignup" method="post" role="form">
            <div class="form-group">
                <strong>FirstName</strong>
            %{--<g:if test="${user?.hasErrors()}">--}%
            %{--1<g:fieldError field="profile.firstname" bean="${user}" >--}%
            %{--2${it.message}--}%
            %{--</g:fieldError>--}%
            %{--<h4><g:enderErrors bean="${user}" field="profile.firstname"/></h4>--}%
            %{--</g:if>--}%
                ${flash.errors?.fieldErrorCount}
                <g:renderErrors bean="${flash.errors}"/>

                <g:if test="${user?.hasErrors()}">
                    <p class="bg-danger">
                        <g:fieldError field="firstname" bean="${user}"></g:fieldError>
                    </p>
                </g:if>
                <g:textField class="form-control" type="text" name="firstname"/>
            </div>

            <div class="form-group">
                <strong>LastName</strong>
                <g:if test="${user?.hasErrors()}">
                    <p class="bg-danger">
                        <g:fieldError field="lastname" bean="${user}"></g:fieldError>
                    </p>
                </g:if>
                <g:textField class="form-control" type="text" name="lastname"/>
            </div>

            <div class="form-group">
                <strong>login/email</strong>
                <g:if test="${user?.hasErrors()}">
                    <p class="bg-danger">
                        <g:fieldError field="username" bean="${user}"></g:fieldError>
                    </p>
                </g:if>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <g:textField class="form-control " type="email" name="username"/>
                </div>
            </div>

            <div class="form-group">
                <strong>password</strong>
                <g:if test="${user?.hasErrors()}">
                    <p class="bg-danger">
                        <g:fieldError field="username" bean="${user}"></g:fieldError>
                    </p>
                </g:if>
                <g:textField class="form-control" type="password" name="password"/>
            </div>

        %{--<div class="form-group">--}%
        %{--<strong>Confirm password</strong>--}%
        %{--<g:if test="${user?.hasErrors()}">--}%
        %{--<div class="label-danger">--}%
        %{--<g:fieldError field="firstname" bean="${user}"></g:fieldError>--}%
        %{--</div>--}%
        %{--</g:if>--}%
        %{--<g:textField class="form-control" type="password" name="confirmpassword"/>--}%
        %{--</div>--}%

            ${profileTypes.type.each { it }}
            <div class="form-group">
                <g:radioGroup class="radio-inline" labels="${profileTypes.type}" name="type" value="1"
                              values="${profileTypes.id}">
                    <div class="radio-inline">
                        <label>${it.radio}${it.label}</label>
                    </div>
                </g:radioGroup>
            </div>
            <g:submitButton class="btn btn-primary col-md-4 pull-right" name="Submit"/>
        </g:form>
    </div>
</div>

</body>
</html>