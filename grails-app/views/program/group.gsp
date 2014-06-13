<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 6/8/2014
  Time: 3:02 PM
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
        <ul class="list-group">
            <a href="${createLink(controller: 'program')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Programs</a>
            <a href="${createLink(controller: 'program', action: 'groups')}" class="list-group-item
            <g:if test="${actionName == 'groups'}">active</g:if>">Groups</a>
        </ul>
    </div>

    <div class="col-md-9">
        <form class="form-inline" style="margin-bottom: 15px" role="form" action="${createLink(action: 'createGroup')}">
            <g:textField class="form-control" type="text" name="name" placeholder="Name"/>
            <g:submitButton class="btn btn-primary form-control" name="submit"/>
        </form>


        <div class="panel panel-default">

            <div class="panel-heading">
                Program Groups
            </div>

            <table class="table table-hover">
                <tr class="info">
                    <th>Name</th>
                    <th>Owner</th>
                    <th>SportProgramsCount</th>
                    <th>Weight</th>
                </tr>
                <g:each in="${groups}" var="group">
                    <tr>
                        <td>${group.name}</td>
                        <td>${group.profile.firstname}</td>
                        <td>${group.sportPrograms.size()}</td>
                        <td>
                            <g:form controller="program" action="deleteGroup">
                                <g:hiddenField name="id" value="${group.id}"/>
                                <g:submitButton class="btn btn-danger" name="Delete group"/>
                            </g:form>
                        </td>
                    </tr>
                </g:each>
            </table>

        </div>
    </div>

    <div class="row">
        %{--<g:paginate controller="program"--}%
        %{--action="index" total="${count}" />--}%
    </div>

</div>
</body>
</html>