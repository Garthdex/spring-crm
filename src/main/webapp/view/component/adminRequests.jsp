<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2 class="sub-header">Customer requests</h2>
<div class="alert alert-success" id="request-success" role="alert"></div>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>User</th>
            <th>Service</th>
            <th>Type</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        </thead>
        <c:forEach items="${requests}" var="request">
        <tr>
            <td>${request.userLogin}</td>
            <td>${request.serviceName}</td>
            <td>${request.serviceType}</td>
            <td>${request.servicePrice}</td>
            <td>
                <form class="status-form form-inline" action="<%=request.getContextPath()%>/changeStatus" method="post">
                    <select data-status="${request.requestStatus}" name="requestStatus" class="form-control select-request">
                        <option value="pending" <c:if test="${request.requestStatus == 'pending'}">selected="selected"</c:if>>pending</option>
                        <option value="approved" <c:if test="${request.requestStatus == 'approved'}">selected="selected"</c:if>>approved</option>
                        <option value="rejected" <c:if test="${request.requestStatus == 'rejected'}">selected="selected"</c:if>>rejected</option>
                    </select>
                    <input name="requestId" type="hidden" value="${request.requestId}"/>
                    <button type="submit" class="btn btn-primary btn-sm">save status</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>