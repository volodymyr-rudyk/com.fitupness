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

<div class="container">

    <div class="row col-md-6 col-md-offset-3 form-group">
        <h3 class="center">Create new Profile</h3>
        <g:form action="doSignup" method="post" enctype="multipart/form-data" role="form">

            <div class="form-group">
                <strong>FirstName</strong>
                <g:textField class="form-control" type="text" name="firstname"/>
            </div>

            <div class="form-group">
                <strong>LastName</strong>
                <g:textField class="form-control" type="text" name="lastname"/>
            </div>

            <div class="form-group">
                <strong>login/email</strong>
                <g:textField class="form-control" type="email" name="username"/>
            </div>

            <div class="form-group">
                <strong>password</strong>
                <g:textField class="form-control" type="password" name="password"/>
            </div>

            <div class="form-group">
                <strong>Comfirm password</strong>
                <g:textField class="form-control" type="password" name="comfirmpassword"/>
            </div>

            <div class="form-group">
                <strong>phone</strong>
                <g:textField class="form-control" type="phone" name="phone"/>
            </div>
[add location]
            <g:submitButton class="btn btn-primary col-md-4 pull-right" name="Submit"/>
        </g:form>
    </div>
</div>

</body>
</html>