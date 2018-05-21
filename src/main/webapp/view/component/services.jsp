<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <c:forEach items="${services}" var="service">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <div class="caption">
                    <form class="service-form" action="<%=request.getContextPath()%>/buyService" method="post">
                        <input name="serviceId" type="hidden" class="form-control" value="<c:out value="${service.serviceId}"/>">
                        <h2>${service.name}</h2>
                        <input name="serviceName" type="hidden" class="form-control" value="<c:out value="${service.name}"/>">
                        <input name="serviceType" type="hidden" class="form-control" value="<c:out value="${service.type}"/>">
                        <h3>${service.price}$/month</h3>
                        <input name="servicePrice" type="hidden" class="form-control" value="<c:out value="${service.price}"/>">
                        <p>${service.description}</p>
                        <input name="serviceDescription" type="hidden" class="form-control" value="<c:out value="${service.description}"/>">
                        <p><button type="submit" class="btn btn-default">Buy</button></p>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
