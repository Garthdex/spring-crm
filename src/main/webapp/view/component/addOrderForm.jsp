<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container order-form-container">
    <div class="alert alert-success" id="order-success" role="alert"></div>
    <form class="form-horizontal order-form" action="<%=request.getContextPath()%>/addOrder" method="POST">
        <div class="form-group">
            <label class="col-sm-2 control-label">Customer login</label>
            <div class="col-sm-6">
                <input name="customerLogin" type="text" class="form-control" placeholder="Peter">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Service</label>
            <div class="col-sm-6">
                <input name="serviceName" type="text" class="form-control" placeholder="100mb">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Date</label>
            <div class="col-sm-6">
                <input name="date" type="text" class="form-control" placeholder="03.05.18">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="submit" class="btn btn-default">Add</button>
            </div>
        </div>
    </form>
</div>
