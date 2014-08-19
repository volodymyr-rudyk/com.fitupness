<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/5/2014
  Time: 6:59 PM
--%>

<ul class="list-group">
    <a href="${createLink(controller: 'user')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Profile</a>

    <a href="${createLink(action: 'programs')}" class="list-group-item
    <g:if test="${(controllerName == 'user' && actionName == 'programs') ||
            (controllerName == 'user' && actionName == 'history')}">active</g:if>">Programs</a>

    <a href="${createLink(action: 'trainerList')}" class="list-group-item
    <g:if test="${actionName == 'trainerList'}">active</g:if>">TrainerList</a>

</ul>