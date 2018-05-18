<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=request.getContextPath()%>/main/">CHI</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">

            <sec:authorize access="!isAuthenticated()">
                <a class="btn btn-default navbar-btn navbar-right" href="<%=request.getContextPath()%>/login">
                    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                </a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/appLogout" method="POST">
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                    </button>
                </form>
                <a class="btn btn-default navbar-btn navbar-right" href="<%=request.getContextPath()%>/profile">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </a>
            </sec:authorize>


        </div><!--/.navbar-collapse -->
    </div>
</nav>


</div>