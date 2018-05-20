<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script src="${pageContext.request.contextPath}/resources/js/component/main.js" type="text/javascript"></script>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar ul">
                <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ANONYMOUS')"><li><a class="get-template" href="<%=request.getContextPath()%>/internet">Internet</a></li></sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ANONYMOUS')"><li><a class="get-template" href="<%=request.getContextPath()%>/tv">TV</a></li></sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ANONYMOUS')"><li><a class="get-template" href="<%=request.getContextPath()%>/phone">Phone</a></li></sec:authorize>
            </ul>
            <ul class="nav nav-sidebar ul">
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"><li class="active"><a class="get-template" href="<%=request.getContextPath()%>/requests">Requests</a></li></sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a class="get-template" href="<%=request.getContextPath()%>/customers">Customers</a></li></sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a class="get-template" href="<%=request.getContextPath()%>/order">Orders</a></li></sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')"><li><a class="get-template" href="<%=request.getContextPath()%>/profile">Profile</a></li></sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ANONYMOUS')"><li><a class="get-template" href="<%=request.getContextPath()%>/help">Help</a></li></sec:authorize>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <sec:authorize access="hasRole('ROLE_ADMIN')"><jsp:include page="../component/adminRequests.jsp"/></sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')"><jsp:include page="../component/userRequests.jsp"/></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><jsp:include page="../component/mainAnon.jsp"/></sec:authorize>
        </div>
    </div>
</div>