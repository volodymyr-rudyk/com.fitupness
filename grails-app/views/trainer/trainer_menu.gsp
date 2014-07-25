<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/7/2014
  Time: 2:53 PM
--%>

<ul class="list-group">
    <a href="${createLink(controller: 'trainer')}" class="list-group-item
            <g:if test="${controllerName == 'trainer' && actionName == 'index'}">active</g:if>">Profile</a>
    <a href="${createLink(controller: 'program')}" class="list-group-item
            <g:if test="${controllerName == 'program'}">active</g:if>">Programs</a>
    <a href="${createLink(controller: 'trainer', action: 'sportsmanList')}" class="list-group-item
            <g:if test="${controllerName == 'trainer' && actionName == 'sportsmanList'}">active</g:if>">SportsmanS</a>
    <a href="${createLink(controller: 'trainer', action: 'claimsList')}" class="list-group-item
            <g:if test="${actionName == 'claimsList'}">active</g:if>">
        <g:if test="${claimsCount > 0}"><span class="badge">${claimsCount}</span></g:if>Claims</a>
    <a href="${createLink(controller: 'sportClub')}" class="list-group-item
            <g:if test="${controllerName == 'sportClub'}">active</g:if>">
        SportClub</a>
</ul>