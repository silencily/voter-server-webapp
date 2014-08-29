<!DOCTYPE html>
<html>
<head>
    <title>Page not found</title>
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
            padding-top: 0px;
        }
    </style>
</head>
<body>

<div class="container" style="min-width: 600px">
    <div class="front-bg">
        <img class="front-image" src="${ctxStatic}/imgs/404.jpg"
             alt="" style="display: block;">
    </div>
    <div class="row" style="margin:25px 150px;height: 50px;">
        <div class="col-md-12">
            <div class="alert alert-warning alert-dismissible" style="text-align: center;" role="alert">
                <button type="button" class="close" data-dismiss="alert">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4><strong>404:</strong> Aha, Page not found!</h4>
                <p>You can search interesting others below.</p>
            </div>
        </div>
    </div>
    <div class="row error-page-main">
        <div class="col-md-12">
            <div>
                <a href="#" class="btn btn-primary btn-lg disabled" role="button">
                    <span class="glyphicon glyphicon-ok"> Voter</span>
                </a>
            </div>
            <div>
                <form role="form" class="error-page-from" action="${ctx}/search">
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="search" class="form-control" id="search" name="q" placeholder="Search votes you interesting">
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-xs-6" style="padding-left: 150px">
                            <button type="submit" class="form-control btn btn-primary">Voter Search</button>
                        </div>
                        <div class="col-xs-6" style="padding-right: 150px">
                            <button type="button" class="form-control btn btn-primary">I'm Feeling Luck</button>
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
        <h4>Powered by bootstrap. Thanks Twitter</h4>
        <h5>Copyright © 2014-2015 org.silencer.silencily All rights reserved.</h5>
    </div>
</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctxStatic}/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctxStatic}/js/bootstrap.js"></script>
</body>
</html>