<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>
<script src="${pageContext.request.contextPath}/resources/js/component/main.js" type="text/javascript"></script>
<div class = "logged">

</div>

<div class="contentBlock">

    <c:if test="${!empty user}">
        <table>
            <tr><td>Name</td><td><c:out value="${user.fullName}"/></td></tr>
            <tr><td>Role</td><td><c:out value="${user.role}"/></td></tr>
            <tr><td>Country</td><td><c:out value="${user.country}"/></td></tr>
        </table>
    </c:if>

</div>