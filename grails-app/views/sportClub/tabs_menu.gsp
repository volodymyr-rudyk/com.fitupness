<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/21/2014
  Time: 2:21 PM
--%>

<ul class="nav nav-tabs" role="tablist">
    <li class="<g:if test="${actionName == 'add'}">active</g:if>">
        <a href="${createLink(controller: 'sportClub', action: 'add')}">Add</a></li>
    <li class="<g:if test="${actionName == 'list'}">active</g:if>">
        <a href="${createLink(controller: 'sportClub', action: 'list')}">List</a></li>
</ul>