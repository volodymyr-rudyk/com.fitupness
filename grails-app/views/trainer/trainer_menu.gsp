<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/7/2014
  Time: 2:53 PM
--%>

<ul class="list-group">
    <a href="${createLink(controller: 'trainer')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Profile</a>
    <a href="${createLink(controller: 'program')}" class="list-group-item
            <g:if test="${controllerName == 'program' && actionName == ''}">active</g:if>">Programs</a>
    <a href="${createLink(controller: 'trainer', action: 'sportsmanList')}" class="list-group-item
            <g:if test="${controllerName == 'trainer' && actionName == 'sportsmanList'}">active</g:if>">Sportsman</a>
    <a href="${createLink(controller: 'trainer', action: 'claimsList')}" class="list-group-item
            <g:if test="${actionName == 'claimsList'}">active</g:if>">
        <g:if test="${claimsCount > 0}"><span class="badge">${claimsCount}</span></g:if>Claims</a>


    <a href="${createLink(controller: 'template')}" class="list-group-item
            <g:if test="${controllerName == 'template'}">active</g:if>">
        Templates</a>

    <a href="${createLink(controller: 'sportClub')}" class="list-group-item
            <g:if test="${controllerName == 'sportClub'}">active</g:if>">
        SportClub</a>
</ul>