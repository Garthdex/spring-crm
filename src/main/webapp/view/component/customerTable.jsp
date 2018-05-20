<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone Number</th>
    </tr>
    </thead>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.userName}</td>
            <td><c:choose><c:when test="${empty customer.fullName}">No information</c:when><c:otherwise>${customer.fullName}</c:otherwise></c:choose></td>
            <td><c:choose><c:when test="${empty customer.address}">No information</c:when><c:otherwise>${customer.address}</c:otherwise></c:choose></td>
            <td><c:choose><c:when test="${empty customer.phoneNumber}">No information</c:when><c:otherwise>${customer.phoneNumber}</c:otherwise></c:choose></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
