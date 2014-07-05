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
        <g:include view="program/program_menu.gsp"/>
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
                    <th>SportProgramsCount</th>
                    <th>Weight</th>
                </tr>
                <g:each in="${groups}" var="group">
                    <tr>
                        <td>${group.name}</td>
                        <td>${group.sportPrograms.size()}</td>

                        <td>
                            <!-- Split button -->
                            <div class="btn-group">
                                <a class="btn btn-success"
                                   href="${createLink(action: 'groups', params: [id: group.id])}">View</a>
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><g:link fragment="#" onclick="setGroupId(${group.id}); " data-toggle="modal"
                                                data-target="#m_delete_group">Delete</g:link></li>
                                </ul>
                            </div>
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


    <div class="modal fade" id="m_delete_group">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Modal title</h4>
                </div>

                <div class="modal-body">
                    <p>One fine</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>


                    <g:form controller="program" action="deleteGroup">
                        <g:hiddenField name="id" id="id"/>
                        <g:submitButton class="btn btn-primary" name="Delete group"/>
                    </g:form>

                    %{--<button type="button" class="btn btn-primary">Save changes</button>--}%
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>

<g:javascript>
    function setGroupId(id) {
        $(".modal-content #id").val(id);
    }
</g:javascript>
</body>
</html>