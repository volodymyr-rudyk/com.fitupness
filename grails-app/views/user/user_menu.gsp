<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/5/2014
  Time: 6:59 PM
--%>

<ul class="list-group">
    <a href="${createLink(controller: 'user')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Profile</a>
    %{--<a href="${createLink(controller: 'program')}" class="list-group-item">PROGRAM</a>--}%
    <a href="${createLink(action: 'trainerList')}" class="list-group-item">TrainerList</a>
</ul>