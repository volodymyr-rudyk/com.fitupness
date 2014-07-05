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

<h1>Programs</h1>

<div class="row">
    <div class="col-md-3">
        <g:include view="program/program_menu.gsp"/>
    </div>

    <div class="col-md-9">
        <form class="form-inline" method="post" style="margin-bottom: 15px" role="form"
              action="${createLink(action: 'create')}">
            <g:textField class="form-control" type="text" name="name" placeholder="Name"/>
            <g:textField class="form-control" type="text" name="repetition" placeholder="repetition"/>
            <g:textField class="form-control" type="text" name="count" placeholder="count"/>
            <g:textField class="form-control" type="text" name="weight" placeholder="weight"/>
            <g:select name="group" from="${groups}" optionKey="id" optionValue="name" class="form-control"/>
            %{--<g:each in="${groups}" var="group">
                <option value="${group.id}">${group.name}</option>
            </g:each>
        </select>--}%
            <g:submitButton class="btn btn-primary form-control" name="submit"/>
        </form>


        <div class="panel panel-default">

            <div class="panel-heading">
                Programs
            </div>

            <table class="table table-hover">
                <tr class="info">
                    <th>Name</th>
                    <th>Repetition</th>
                    <th>Count</th>
                    <th>Weight</th>
                    %{--<th>Owner Name</th>--}%
                    <th>Group Name</th>
                    <th>btn</th>
                </tr>
                <g:each in="${programs}" var="program">
                    <tr>
                        <td>${program.name}</td>
                        <td>${program.repetition}</td>
                        <td>${program.count}</td>
                        <td>${program.weight}</td>
                    %{--<td>${program.trainer.profile.firstname}</td>--}%
                        <g:if test="${groups.size() > 0}">
                            <td>
                                ${program.groups[0]?.name}
                            </td>
                        </g:if>
                        <td>
                            <g:form controller="program" action="delete">
                                <g:hiddenField name="id" value="${program.id}"/>
                                <g:submitButton class="btn btn-danger" name="Delete"/>
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