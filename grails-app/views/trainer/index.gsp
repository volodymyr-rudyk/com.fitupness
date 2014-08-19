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
        <div>firstname : ${trainer.profile.firstname}</div>
        <div>lastname : ${trainer.profile.lastname}</div>
        <div>address : ${trainer.profile.address?.country?.country},
            ${trainer.profile.address?.city?.city}</div>
        <div>body weight : ${trainer.profile.body?.weight}</div>
        <div>profile type : ${trainer.profile.profileType?.type}</div>

        <div>rating : ${trainer?.profile.rating?.points}</div>

    </div>
</div>

</body>
</html>