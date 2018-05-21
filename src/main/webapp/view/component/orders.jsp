<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h2 class="sub-header">Orders</h2>
<a class="btn btn-primary btn-sm get-order-form" href="<%=request.getContextPath()%>/addOrderForm">add order</a>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>User</th>
            <th>Service</th>
            <th>Type</th>
            <th>Price/Month</th>
            <th>Date</th>
            <th>Manager</th>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.customerLogin}</td>
                <td>${order.serviceName}</td>
                <td>${order.serviceType}</td>
                <td>${order.servicePrice}$</td>
                <td>${order.date}</td>
                <td>${order.managerName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>