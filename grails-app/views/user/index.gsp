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
        <div>firstname : ${sportsman.profile.firstname}</div>
        <div>lastname : ${sportsman.profile.lastname}</div>
        <div>address : ${sportsman.profile.address?.country?.country},
            ${sportsman.profile.address?.city?.city}</div>
        <div>body weight : ${sportsman.profile.body?.weight}</div>
        <div>profile type : ${sportsman.profile.profileType?.type}</div>

        <div>trainer : <link:profileLink
                id="${sportsman?.trainer?.profile?.id}">${sportsman?.trainer?.profile?.firstname}&nbsp;${sportsman?.trainer?.profile?.lastname}</link:profileLink>
        </div>

        <div>rating : ${sportsman?.profile.rating?.points}</div>
    </div>
</div>

</body>
</html>