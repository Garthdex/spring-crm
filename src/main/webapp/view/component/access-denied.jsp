<html>
    <head>
        <title>Error</title>
    </head>
    <body>
      <h3>You are not authorized to access this.</h3>
      <form action="<%=request.getContextPath()%>/appLogout" method="POST">
        <input type="submit" value="Logout"/>
      </form> 
    </body>
</html> 