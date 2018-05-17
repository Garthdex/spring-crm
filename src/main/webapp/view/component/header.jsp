

<div class="header">

    <div class="rowHeader">
        <sec:authorize access="!isAuthenticated()">
            <a href="<%=request.getContextPath()%>/login">login</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <form action="<%=request.getContextPath()%>/appLogout" method="POST">
                <input type="submit" class = "logOut btn btn-large btn-primary" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
    </div>

</div>