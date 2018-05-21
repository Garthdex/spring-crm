<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/resources/js/component/login.js" type="text/javascript"></script>
<div class="container">
    <div class="content">
        <font color="red">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </font>
        <form class="form-horizontal loginDiv" action="<%=request.getContextPath()%>/appLogin" method="POST">
            <div class="form-group">
                <c:if test="${!empty errorMessageLogin}"><div class="alert alert-warning" role="alert">${errorMessageLogin}</div></c:if>
                <c:if test="${!empty errorMessagePassword}"><div class="alert alert-warning" role="alert">${errorMessagePassword}</div></c:if>
                <c:if test="${!empty errorMessageRegistration}"><div class="alert alert-warning" role="alert">${errorMessageRegistration}</div></c:if>
                <c:if test="${!empty successMessage}"><div class="alert alert-success" role="alert">${successMessage}</div></c:if>
                <label for="inputLogin">Login</label>
                <input class = "form-control" type="text" name="app_username" id="inputLogin" class="inputLogin" placeholder="Login">
            </div>
            <div class="form-group">
                <label for="inputPassword">Password</label>
                <input class = "form-control" type="password" name="app_password" id="inputPassword" class="inputPassword" placeholder="Password">
            </div>
            <div class="form-group">
                <div class="switch">
                    Haven't account yet? Please, <a class="registerLink" href="#">register</a>
                    <button type="submit" class="btn signIn">Sign in</button>
                </div>
            </div>
        </form>

        <form class="form-horizontal registerDiv" action="<%=request.getContextPath()%>/register" method="POST" disabled hidden>
            <div class="form-group">
                <label for="inputRegisterLogin">Login</label>
                <div class="alert alert-warning jsErrorRegistrationLogin" role="alert" hidden>
                    Login field must not be empty
                </div>
                <input class = "form-control" type="text" name="registerLogin" id="inputRegisterLogin" class="jsInputRegisterLogin" placeholder="Login">
            </div>
            <div class="form-group">
                <label for="inputRegisterPassword">Password</label>
                <div class="alert alert-warning jsErrorRegistrationPassword" role="alert" hidden>
                    Password field must not be empty
                </div>
                <div class="alert alert-warning jsErrorRegistrationPasswordNotMatch" role="alert" hidden>
                    Password field doesn't match with Confirm password field
                </div>
                <input class = "form-control" type="password" name="registerPassword" id="inputRegisterPassword" class="jsInputRegisterPassword" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="inputRegisterPasswordAgain">Confirm your password</label>
                <div class="alert alert-warning jsErrorRegistrationPasswordAgain" role="alert" hidden>
                    Confirm password field must not be empty
                </div>
                <input class = "form-control" type="password" id="inputRegisterPasswordAgain" class="jsInputRegisterPasswordAgain" placeholder="Enter password again">
            </div>
            <div class="form-group">
                <div class="switch">
                    Have account already? Please, <a class="loginLink" href="#"> login </a>
                    <button type="submit" class="btn jsSignUp">Sign up</button>
                </div>
            </div>
        </form>
    </div>
</div>