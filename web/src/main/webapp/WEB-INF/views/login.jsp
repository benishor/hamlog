<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sign in with HamLog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Adrian Scripca">

    <link href="${contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <link href="${contextPath}/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="${contextPath}/assets/jquery/jquery-1.9.1.min.js"></script>
    <script src="${contextPath}/assets/bootstrap/js/bootstrap.js"></script>
    <script language="JavaScript">
        $(function () {
            $('#callsign').focus();
        });
    </script>
</head>

<body>
    <div class="container">

        <form class="form-signin" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" id="callsign" name='j_username' class="input-block-level" placeholder="Callsign"/>
            <input type="password" id="password" name='j_password' class="input-block-level" placeholder="Password"/>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
            <c:if test="${not empty error}">
                <div class="control-group error">
                        <c:out value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" escapeXml="true" />
                </div>
            </c:if>

            <button class="btn btn-large btn-primary" type="submit">Sign in</button>
        </form>

    </div>
    <!-- /container -->

</body>
</html>

<%--<html>--%>
<%--<head>--%>
<%--<title>Login Page</title>--%>
<%--<style>--%>
<%--.errorblock {--%>
<%--color: #ff0000;--%>
<%--background-color: #ffEEEE;--%>
<%--border: 3px solid #ff0000;--%>
<%--padding: 8px;--%>
<%--margin: 16px;--%>
<%--}--%>
<%--</style>--%>
<%--</head>--%>
<%--<body onload='document.f.j_username.focus();'>--%>
<%--<h3>Login with Username and Password (Custom Page)</h3>--%>

<%--<c:if test="${not empty error}">--%>
<%--<div class="errorblock">--%>
<%--Your login attempt was not successful, try again.<br/> Caused :--%>
<%--${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}--%>
<%--</div>--%>
<%--</c:if>--%>


<%--<img src="${contextPath}/assets/yo6ssw.png" />--%>

<%--<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td>User:</td>--%>
<%--<td><input type='text' name='j_username' value=''></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Password:</td>--%>
<%--<td><input type='password' name='j_password'/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="submit" type="submit" value="submit"/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="reset" type="reset"/></td>--%>
<%--</tr>--%>
<%--</table>--%>

<%--</form>--%>
<%--</body>--%>
</html>