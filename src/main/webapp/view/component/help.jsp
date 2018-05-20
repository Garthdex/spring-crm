<form class="help-form" action="<%=request.getContextPath()%>/saveHelp" method="post">
    <div class="alert alert-success" id="help-success" role="alert"></div>
    <div class="form-group">
        <label>Phone number</label>
        <input name = "phoneNumber" type="text" class="form-control" placeholder="7054476391">
    </div>
    <div class="form-group">
        <label>Message</label>
        <textarea name="message" type="text" class="form-control" placeholder="Your message"></textarea>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>