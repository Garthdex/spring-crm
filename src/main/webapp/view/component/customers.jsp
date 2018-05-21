<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2 class="sub-header">Customers</h2>
<form class="form-inline search-customers" action="${pageContext.request.contextPath}/customersByLogin" method="post">
    <div class="form-group">
        <input name="login" type="search" class="form-control" placeholder="type customer login">
    </div>
    <button type="submit" class="btn btn-default">search</button>
</form>
<div class="table-responsive">
    <jsp:include page="customerTable.jsp"/>
</div>