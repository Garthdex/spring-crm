<html>
    <head>
        <title>Error</title>
        <jsp:include page="../component/links.jsp"/>
    </head>
    <body>
    <jsp:include page="../component/header.jsp"/>
    <div class="container">
        <div class="content">
      <form class="form-horizontal" action="<%=request.getContextPath()%>/main" method="POST">
          <div class="form-group">
              <div class="alert alert-warning" role="alert">You are not authorized to access this</div>
          </div>
          <div class="form-group">
              <button type="submit" class="btn btn-default">Go to main page</button>
          </div>
      </form>
        </div>
    </div>
    <jsp:include page="../component/footer.jsp"/>
    </body>
</html> 