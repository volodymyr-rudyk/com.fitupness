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

<div class="row">
    <div class="col-md-3">
        <g:include view="trainer/trainer_menu.gsp"/>
    </div>

    <div class="col-md-9">
        <g:include view="program/program_menu.gsp"/>

        <div class="tab-content">
            <form class="form-inline" method="post" style="margin-bottom: 15px" role="form"
                  action="${createLink(controller: 'program', action: 'createTemplate')}">
                <g:textField class="form-control" type="text" name="name" placeholder="Name"/>
                <g:textField class="form-control" type="text" name="repetition" placeholder="repetition"/>
                <g:textField class="form-control" type="text" name="count" placeholder="count"/>
                <g:textField class="form-control" type="text" name="weight" placeholder="weight"/>
                <g:submitButton class="btn btn-primary form-control" name="submit"/>
            </form>


            <div class="panel panel-default">
                <div class="panel-heading">Programs</div>

                <table class="table table-hover">
                    <tr class="info">
                        <th>Name</th>
                        <th>Repetition</th>
                        <th>Count</th>
                        <th>Weight</th>
                        <th>Group Name</th>
                        <th>btn</th>
                    </tr>
                    <g:each in="${templates}" var="template">
                        <tr>
                            <td>${template.name}</td>
                            <td>${template.repetition}</td>
                            <td>${template.count}</td>
                            <td>${template.weight}</td>
                            <td>template.group</td>
                            <td><a href="${createLink(controller: 'program', action: 'deleteTemplate', id: template.id)}">remove</a>
                            </td>
                        </tr>
                    </g:each>
                </table>

            </div>
        </div>
    </div>
</div>

</body>
</html>



