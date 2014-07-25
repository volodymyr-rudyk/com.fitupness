<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/4/2014
  Time: 11:04 PM
--%>


<ul class="nav nav-tabs" style="margin-bottom: 18px">
    <li class=" <g:if test="${actionName == 'groups'}">active</g:if>">
        <a href="${createLink(controller: 'program', action: 'groups')}">Groups</a></li>
    <li class="<g:if test="${actionName == 'index'}">active</g:if>">
        <a href="${createLink(controller: 'program')}">Programs</a></li>
    <li class="<g:if test="${controllerName == 'program' && actionName == 'templates'}">active</g:if>">
        <a href="${createLink(controller: 'program', action: 'templates')}">Templates</a></li>
</ul>
