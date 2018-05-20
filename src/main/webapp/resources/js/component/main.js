$(document).ready(function(){
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

        var templateSelector = '.get-template';
        $(templateSelector).click(function (e) {
            e.preventDefault();
            var href = $(this).attr('href');
            render(href, this);
        });

        $(".search-customers").submit(function (e) {
            e.preventDefault();
            var href = $(this).attr("action");
            postSearchCustomers(href, $(this));
        })
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
        })
    }

    function postSearchCustomers(href, form) {
        $.post(href, form.serialize(), function (template) {
            $(".table-responsive").html(template);
        })
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