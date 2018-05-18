<%--<c:if test="${!empty user}">--%>
    <%--<table>--%>
        <%--<tr><td>Name</td><td><c:out value="${user.fullName}"/></td></tr>--%>
        <%--<tr><td>Role</td><td><c:out value="${user.role}"/></td></tr>--%>
    <%--</table>--%>
<%--</c:if>--%>
<div class="container main-container">
        <form class="form-horizontal" action="<%=request.getContextPath()%>/updateUser" method="POST">
            <div class="form-group">
                <label class="col-sm-2 control-label">Login</label>
                <div class="col-sm-6">
                    <input name="login" type="text" class="form-control" value="user_login" disabled>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Name</label>
                <div class="col-sm-6">
                    <input name="name" type="text" class="form-control" value="user_name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Address</label>
                <div class="col-sm-6">
                    <input name="address" type="text" class="form-control" value="user_address">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Phone number</label>
                <div class="col-sm-6">
                    <input name="phoneNumber" type="text" class="form-control" value="user_phoneNumber">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-default">Save</button>
                </div>
            </div>
        </form>
</div>
