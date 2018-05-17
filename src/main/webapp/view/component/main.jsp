<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<script src="${pageContext.request.contextPath}/resources/js/component/main.js" type="text/javascript"></script>
<div class = "logged">


    <a href="${pageContext.request.contextPath}/logout" class = "logOut btn btn-large btn-primary">
        LogOut
    </a>
</div>

<div class="contentBlock">
    {$main}
</div>