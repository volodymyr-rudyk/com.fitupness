<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 7/4/2014
  Time: 11:04 PM
--%>



<ul class="list-group">

    <a href="${createLink(controller: 'template', action: 'groups')}" class="list-group-item
            <g:if test="${actionName == 'groups'}">active</g:if>">Groups</a>
    <a href="${createLink(controller: 'template')}" class="list-group-item
            <g:if test="${actionName == 'index'}">active</g:if>">Templates</a>

</ul>
