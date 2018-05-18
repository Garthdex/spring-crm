<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:if test="${!empty user}">--%>
    <%--<table>--%>
        <%--<tr><td>Name</td><td><c:out value="${user.fullName}"/></td></tr>--%>
        <%--<tr><td>Role</td><td><c:out value="${user.role}"/></td></tr>--%>
    <%--</table>--%>
<%--</c:if>--%>
<div class="container main-container">
    <c:if test="${!empty successMessage}"><div class="alert alert-success" role="alert">${successMessage}</div></c:if>
        <form class="form-horizontal" action="<%=request.getContextPath()%>/updateUser" method="POST">
            <input name="id" type="hidden" class="form-control" value="<c:out value="${user.userId}"/>">
            <div class="form-group">
                <label class="col-sm-2 control-label">Login</label>
                <div class="col-sm-6">
                    <input name="login" type="text" class="form-control" value="<c:out value="${user.userName}"/>" disabled>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Name</label>
                <div class="col-sm-6">
                    <input name="name" type="text" class="form-control" value="<c:if test="${not empty user.fullName}"><c:out value="${user.fullName}"/></c:if>" placeholder="Peter Parker">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Address</label>
                <div class="col-sm-6">
                    <input name="address" type="text" class="form-control" value="<c:if test="${not empty user.address}"><c:out value="${user.address}"/></c:if>" placeholder="St. Paulo Street 15">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Phone number</label>
                <div class="col-sm-6">
                    <input name="phoneNumber" type="text" class="form-control" value="<c:if test="${not empty user.phoneNumber}"><c:out value="${user.phoneNumber}"/></c:if>" placeholder="7054476391">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-default">Save</button>
                </div>
            </div>
        </form>
</div>
