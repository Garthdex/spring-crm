$(document).ready(function(){
    var templateSelector = '.get-template';
    $(templateSelector).click(function (e) {
        e.preventDefault();
        var href = $(this).attr('href');
        render(href, this);
    });
    setListeners();

    function setListeners() {
        $(".help-form").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            $('#help-success').hide();
            postHelpForm(href, $(this));
            return false;
        });

        $(".select-request").change(function () {
            if ($(this).data("status") === this.value) {
                $(this).parent('.status-form').children('.btn').hide();
            } else {
                $(this).parent(".status-form").children(".btn").show();
            }
        });

        $(".status-form").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postChangeStatus(href, $(this));
        });

        $(".search-customers").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postSearchCustomers(href, $(this));
        });

        $(".order-form").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postAddOrder(href, $(this));
        });

        $(".service-form").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postBuyService(href, $(this));
        });

        $(".buy-form").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postAddRequest(href, $(this));
        });

        $(".get-order-form").click(function (e) {
            e.preventDefault();
            var href = $(this).attr('href');
            getOrderForm(href);
        })
    }

    function getOrderForm(href) {
        $.get(href, function(data) {
            $(".main").html(data);
            setListeners();
        });
    }

    function postHelpForm(href, form) {
        $.post(href, form.serialize(), function () {
            $('#help-success').html("Successfully submit");
            $('#help-success').show();
        });
    }
    
    function postChangeStatus(href, form) {
        $.post(href, form.serialize(), function () {
            $('#request-success').html("Successfully changed!");
            $('#request-success').show();
        });
    }

    function postSearchCustomers(href, form) {
        $.post(href, form.serialize(), function (template) {
            $(".table-responsive").html(template);
        });
    }

    function postAddOrder(href, form) {
        $.post(href, form.serialize(), function () {
            $('#order-success').html("Order successfully added!");
            $('#order-success').show();
        });
    }

    function postBuyService(href, form) {
        $.post(href, form.serialize(), function (data) {
            $(".main").html(data);
            setListeners();
        });
    }

    function postAddRequest(href, form) {
        $.post(href, form.serialize(), function (data) {
            $(".main").html(data);
            setListeners();
        });
    }

    function render(href, link) {
        $.get(href, function(data) {
            $( "ul.nav.nav-sidebar li" ).removeClass("active");
            $(link).parent("ul.nav.nav-sidebar li").addClass("active");
            $(".main").html(data);
            console.log("Load was performed.");
            setListeners();
        });
    }



});