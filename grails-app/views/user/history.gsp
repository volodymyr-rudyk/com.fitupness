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

    <div class="col-md-9">
        <h2>History</h2>

        <div class="panel panel-default">

            <table class="table">
                <tr class="info">
                    <th>Name</th>
                    <th>repetition</th>
                    <th>count</th>
                    <th>weight</th>
                    <th>date</th>
                    %{--<th>trainer</th>--}%
                    <th>status</th>
                    <th></th>
                </tr>
                <g:each in="${sportPrograms}" var="sportProgram">
                    <tr>
                        <td>${sportProgram.name}</td>
                        <td>${sportProgram.repetition}</td>
                        <td>${sportProgram.count}</td>
                        <td>${sportProgram.weight}</td>
                        %{--<td><g:formatDate format="yyyy-MM-dd" date="${sportProgram.lastUpdated}"/></td>--}%
                        <td><g:formatDate date="${sportProgram.lastUpdated}" type="datetime" style="LONG"/></td>
                        %{--<td>--}%
                        %{--<link:profileLink id="${sportProgram.trainer.profile.id}">View</link:profileLink>--}%
                        %{--</td>--}%
                        <td><div id="status_${sportProgram.id}">${sportProgram.status.status}</div></td>
                        <td>

                    </tr>
                </g:each>
            </table>
        </div>
    </div>
</div>
</body>
</html>