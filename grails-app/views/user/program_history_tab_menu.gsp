<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 8/19/2014
  Time: 1:32 PM
--%>

<ul class="nav nav-tabs" style="margin-bottom: 18px">
    <li class="<g:if test="${actionName == 'programs'}">active</g:if>">
        <a href="${createLink(controller: 'user', action: 'programs')}">Programs</a></li>
    <li class="<g:if test="${actionName == 'history'}">active</g:if>">
        <a href="${createLink(controller: 'user', action: 'history')}">history</a></li>
</ul>