<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2 class="sub-header">Your requests</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Service</th>
            <th>Type</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        </thead>
        <c:forEach items="${requests}" var="request">
            <tr>
                <td>${request.serviceName}</td>
                <td>${request.serviceType}</td>
                <td>${request.servicePrice}</td>
                <td>${request.requestStatus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>