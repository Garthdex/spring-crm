<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container buy-container">

    <form class="form-horizontal buy-form" action="<%=request.getContextPath()%>/addRequest" method="POST">
        <div class="form-group">
            <label class="col-sm-2 control-label">Service</label>
            <div class="col-sm-6">
                <label class="control-label">${service.type} ${service.name}</label>
            </div>
            <input name="serviceId" type="hidden" class="form-control" value="<c:out value="${service.serviceId}"/>">

        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Price/Month</label>
            <div class="col-sm-6">
                <label class="control-label">${service.price}$</label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Description</label>
            <div class="col-sm-6">
                <label class="control-label">${service.description}</label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Your address</label>
            <div class="col-sm-6">
                <label class="control-label">
                    <c:choose>
                        <c:when test="${not empty user.address}">
                            <c:out value="${user.address}"/>
                        </c:when>
                        <c:otherwise>
                            You can't apply the request until you add address in profile
                        </c:otherwise>
                    </c:choose>
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Your phone number</label>
            <div class="col-sm-6">
                <label class="control-label">
                    <c:choose>
                        <c:when test="${not empty user.phoneNumber}">
                            <c:out value="${user.phoneNumber}"/>
                        </c:when>
                        <c:otherwise>
                            You can't apply the request until you add phone number in profile
                        </c:otherwise>
                    </c:choose>
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="submit" class="btn btn-default" <c:if test="${empty user.phoneNumber or user.address}">disabled</c:if> >Apply</button>
            </div>
        </div>
    </form>
</div>
