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
        <h2>Programs</h2>

        <div class="panel panel-default">

            <table class="table">
                <tr class="info">
                    <th>Name</th>
                    <th>repetition</th>
                    <th>count</th>
                    <th>weight</th>
                    <th>dateCreated</th>
                    <th>trainer</th>
                    <th>status</th>
                    <th></th>
                </tr>
                <g:each in="${sportPrograms}" var="sportProgram">
                    <tr>
                        <td>${sportProgram.name}</td>
                        <td>${sportProgram.repetition}</td>
                        <td>${sportProgram.count}</td>
                        <td>${sportProgram.weight}</td>
                        <td>${sportProgram.dateCreated}</td>
                        <td>
                            <link:profileLink id="${sportProgram.trainer.profile.id}">View</link:profileLink>
                        </td>
                        <td><div id="status_${sportProgram.id}">${sportProgram.status.status}</div></td>
                        <td>
                            <div class="btn-group">

                                %{--<button type="button" class="btn btn-primary" onclick="<g:remoteFunction
                                        controller="program"
                                        action="programStatus"
                                        params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 1"
                                        update="status_${sportProgram.id}"/>">Start</button>

                                <button type="button" class="btn btn-warning" onclick="<g:remoteFunction
                                        controller="program"
                                        action="programStatus"
                                        params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 4"
                                        update="status_${sportProgram.id}"/>">Suspend</button>

                                <button type="button" class="btn btn-info" onclick="<g:remoteFunction
                                        controller="program"
                                        action="programStatus"
                                        params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 3"
                                        update="status_${sportProgram.id}"/>">Stop</button>

                                <button type="button" class="btn btn-success" onclick="<g:remoteFunction
                                        controller="program"
                                        action="programStatus"
                                        params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 2"
                                        update="status_${sportProgram.id}"/>">Done</button>--}%

                                <button type="button" class="btn"
                                        onclick="<g:remoteFunction
                                                controller="program"
                                                action="programStatus"
                                                params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 1"
                                                update="status_${sportProgram.id}"/>">Start</button>
                                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#" onclick="<g:remoteFunction
                                            controller="program"
                                            action="programStatus"
                                            params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 4"
                                            update="status_${sportProgram.id}"/>">Suspend</a></li>
                                    <li><a href="#" onclick="<g:remoteFunction
                                            controller="program"
                                            action="programStatus"
                                            params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 3"
                                            update="status_${sportProgram.id}"/>">Stop</a></li>
                                    <li><a href="#" onclick="<g:remoteFunction
                                            controller="program"
                                            action="programStatus"
                                            params="\'idProgram=\' + ${sportProgram.id} + \'&idStatus=\' + 2"
                                            update="status_${sportProgram.id}"/>">Done</a></li>
                                </ul>
                            </div>
                    </tr>
                </g:each>
            </table>

        </div>
    </div>
</div>
</body>
</html>