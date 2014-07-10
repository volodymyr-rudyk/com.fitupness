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
        <div class="panel panel-default">
            <div class="panel-heading">
                Sportsman List
            </div>

            <table class="table table-hover">
                <tr class="info">
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Phone</th>
                </tr>
                <g:each in="${sportsmans}" var="sportsman">
                    <tr>
                        <td>${sportsman.profile.firstname}</td>
                        <td>${sportsman.profile.lastname}</td>
                        <td>${sportsman.profile.phone}</td>
                        <td>
                            <link:profileLink id="${sportsman.profile.id}">View</link:profileLink>
                        </td>
                        <td><g:link id="snd" fragment="#" onclick="setSportsmanId(${sportsman.id});" data-toggle="modal"
                                    data-target="#m_send_program">SendProgram</g:link></td>

                    </tr>
                </g:each>
            </table>

        </div>
    </div>

</div>


<div class="modal fade" id="m_send_program">
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

                <g:form controller="program" action="send">
                    <g:hiddenField name="idSportsman" id="idSportsman"/>
                    <select id="spList" name="idProgram" class="form-control"/>

                    <g:submitButton class="btn btn-primary" name="Send"/>
                </g:form>

            %{--<button type="button" class="btn btn-primary">Save changes</button>--}%
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<g:javascript>
    function setSportsmanId(idSportsman) {
        $(".modal-content #idSportsman").val(idSportsman);

        var url = "${createLink(controller: 'program', action: 'list')}"
        jQuery.ajax({
            url: url,
            type: "POST",
            data: {}
        }) .done(function( data ) {
            var programs = data.programs;

            var select  = document.getElementById('spList');
            var length = programs.length

            for(var i = 0; i < length; i++){
                var op = document.createElement("OPTION");
                op.value = programs[i].id;
                op.text = programs[i].name;
                select.appendChild(op);
            }
        });
    }

    $('#m_send_program').on('show.bs.modal', function (e) {


        $('#spList').val()
    });

%{--$('snd').onclick = <g:remoteFunction action="show" id="1"/>--}%
</g:javascript>
</body>
</html>