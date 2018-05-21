<div class="container">
    <div class="content">
        <form class="form-horizontal" action="<%=request.getContextPath()%>/main" method="POST">
            <div class="form-group">
                <div class="alert alert-success" role="alert">${successMessage}</div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default">Go to main page</button>
            </div>
        </form>
    </div>
</div>
