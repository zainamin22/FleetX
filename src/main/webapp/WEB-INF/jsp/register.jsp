<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title></title>


        <link rel="stylesheet" href="resources/css/registerstyle.css"/>



        <link href='https://fonts.googleapis.com/css?family=Playfair+Display' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>

    </head>

    <body>
        <div id="main-wrapper">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 left-side">
                        <header>
                            <span style="color: #014880;">FleetX</span>
                            <h3>Create Account</h3>
                        </header>
                    </div>
                    <div class="col-md-6 right-side">


                        <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">

                            <span class="input input--hoshi">
                                <form:input class="input__field input__field--hoshi" type="text" path="email" id="email"/>
                                <label class="input__label input__label--hoshi input__label--hoshi-color-3" for="email">
                                    <span class="input__label-content input__label-content--hoshi">E-mail</span>
                                </label>
                            </span>
                            <span class="input input--hoshi">
                                <form:input class="input__field input__field--hoshi" type="password" path="password" id="password"/>
                                <label class="input__label input__label--hoshi input__label--hoshi-color-3" for="password">
                                    <span class="input__label-content input__label-content--hoshi">Password</span>
                                </label>
                            </span>
                            <span class="input input--hoshi">
                                <form:input class="input__field input__field--hoshi" type="password" path="" id="password1"/>
                                <label class="input__label input__label--hoshi input__label--hoshi-color-3" for="password1">
                                    <span class="input__label-content input__label-content--hoshi">Repeat Passowrd</span>
                                </label>
                            </span>
                            <div class="cta">
                                <form:input type="submit" value="Sign-Up Now" style="background: #014880;" path="" class="btn btn-primary pull-left"/>
                            </form:form>
                            <span><a href="login">I am already a member</a></span>
                        </div>
                     
                    </div>
                </div>
            </div>

        </div> <!-- end #main-wrapper -->

        <!-- Scripts -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="resources/js/register.js"></script><script>eval(mod_pagespeed_$l9NZilChO);</script>
        <script>eval(mod_pagespeed_CItQrTdiCu);</script>
        <script>(function () {
                if (!String.prototype.trim) {
                    (function () {
                        var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                        String.prototype.trim = function () {
                            return this.replace(rtrim, '');
                        };
                    })();
                }
                [].slice.call(document.querySelectorAll('input.input__field')).forEach(function (inputEl) {
                    if (inputEl.value.trim() !== '') {
                        classie.add(inputEl.parentNode, 'input--filled');
                    }
                    inputEl.addEventListener('focus', onInputFocus);
                    inputEl.addEventListener('blur', onInputBlur);
                });
                function onInputFocus(ev) {
                    classie.add(ev.target.parentNode, 'input--filled');
                }
                function onInputBlur(ev) {
                    if (ev.target.value.trim() === '') {
                        classie.remove(ev.target.parentNode, 'input--filled');
                    }
                }
            }
            )();</script>

    </body>
</html>
