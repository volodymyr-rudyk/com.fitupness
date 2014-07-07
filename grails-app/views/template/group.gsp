<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/3/2014
  Time: 11:14 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Programs</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h1>Program groups</h1>

<div class="row">
    <div class="col-md-3">
        <g:include view="program/program_menu.gsp"/>
    </div>

    <div class="col-md-9">
        <div class="panel panel-default">

            <g:if test="${group}">
                <div class="panel-heading">
                    Program Group <strong>${group.name}</strong>
                </div>

                <table class="table table-hover">
                    <tr class="info">
                        <th>Name</th>
                        <th>Count</th>
                        <th>repetition</th>
                        <th>weight</th>
                    </tr>
                    <g:each in="${group.sportPrograms}" var="sportProgram">
                        <tr>
                            <td>${sportProgram.name}</td>
                            <td>${sportProgram.count}</td>
                            <td>${sportProgram.repetition}</td>
                            <td>${sportProgram.weight}</td>
                        </tr>
                    </g:each>
                </table>
            </g:if>
            <g:else>
                <div class="panel-heading">
                    Data not found
                </div>
            </g:else>

        </div>
    </div>

</div>
</body>
</html>