$(document).ready(function(){
    $('.registerLink').click(function(e){
        e.preventDefault();
        $('.loginDiv').hide();
        $('.loginDiv').prop("disabled", true);
        $('.registerDiv').show();
        $('.registerDiv').prop("disabled", false);
    });

    $('.loginLink').click(function(e){
        e.preventDefault();
        $('.registerDiv').hide();
        $('.registerDiv').prop("disabled", true);
        $('.loginDiv').show();
        $('.loginDiv').prop("disabled", false);
    });

    var body = $('body');

    function validateRegisterFields(login, password, passwordAgain, e) {
        if (login === null || login === "") {
            $('.jsErrorRegistrationLogin').show();
            e.preventDefault();
        } else {
            $('.jsErrorRegistrationLogin').hide();
        }
        if (password === null || password === "") {
            $('.jsErrorRegistrationPassword').show();
            e.preventDefault();
        } else {
            $('.jsErrorRegistrationPassword').hide();
        }
        if (passwordAgain === null || passwordAgain === "") {
            $('.jsErrorRegistrationPasswordAgain').show();
            e.preventDefault();
        } else {
            $('.jsErrorRegistrationPasswordAgain').hide();
        }
        if (password !== passwordAgain) {
            $('.jsErrorRegistrationPasswordNotMatch').show();
            e.preventDefault();
        } else {
            $('.jsErrorRegistrationPasswordNotMatch').hide();
        }
    }

    body.on('click', '.jsSignUp', function (e) {
        var inputRegisterLogin = $('.jsInputRegisterLogin').val();
        var inputRegisterPassword = $('.jsInputRegisterPassword').val();
        var inputRegisterPasswordAgain = $('.jsInputRegisterPasswordAgain').val();
        validateRegisterFields(inputRegisterLogin, inputRegisterPassword, inputRegisterPasswordAgain, e);
    });
});