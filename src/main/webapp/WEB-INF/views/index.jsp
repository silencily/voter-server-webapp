<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voter</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap.css">
    <link rel="stylesheet" href="${ctxStatic}/css/voter.css">
    <link rel="shortcut icon" href="${ctxStatic}/imgs/favicon.ico">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            padding-top: 50px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${ctx}">Voter</a>
        </div>
    </div>
    <!-- /.container -->
</nav>

<div class="container">
    <div class="front-bg">
        <img class="front-image" src="${ctxStatic}/imgs/frontbg/a.jpg"
             alt="" style="display: block;">
    </div>
    <div class="row front-welcome">
        <div class="col-md-5 col-md-offset-1">
            <div class="welcome-text">
                <h1><spring:message code="txt.page.index.welcome.h"/> </h1>

                <p>
                    <spring:message code="txt.page.index.welcome.msg"/>
                </p>
            </div>
        </div>
        <div class="col-md-4 col-md-offset-1 front-sign">
            <div class="front-signin">
                <form method="post" role="form" id="signin-form" action="${ctx}/j_spring_security_check">
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="text" class="form-control" id="signin-username" name="j_username"
                                   placeholder="Username or email">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 col-signin-password">
                            <input type="password" class="form-control" id="signin-password" name="j_password"
                                   placeholder="Password">
                        </div>
                        <div class="col-xs-4">
                            <button type="submit" class="form-control btn btn-primary">Sign in</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <label>
                                <input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox"> Remember me
                            </label>
                            <span>-</span>
                            <a href="#">Forgot password?</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="front-signup">
                <h2><strong>New to Voter?</strong> Sign up</h2>

                <form role="form" id="signup-form" action="${ctx}/signup" method="post">
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="text" class="form-control" id="signup-fullname" name="fullname"
                                   placeholder="Full name">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="text" class="form-control" id="signup-email" name="email"
                                   placeholder="Email">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="password" class="form-control" id="signup-password" name="password"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="submit" class="form-control btn btn-primary">Sign up for Voter</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /container -->
<nav class="navbar navbar-default navbar-fixed-bottom front-footer" role="navigation">
    <div class="container">
        <h5 style="color: #000;">Copyright © 2014-2017 org.silencer.silencily All rights reserved.</h5>
        <h6><a href="${ctx}/?lang=zh_CN">中文</a> <span style="color: #428bca;margin:0 5px;">|</span> <a href="${ctx}/?lang=en_US">English</a></h6>
    </div>
</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctxStatic}/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctxStatic}/js/bootstrap.js"></script>
</body>
</html>