<!DOCTYPE html>
<html>
<head>
    <title>Voter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="./static/css/bootstrap.css">
    <link rel="stylesheet" href="./static/css/main.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Voter</a>
        </div>
        -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-globe"></span> Discover</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Me</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-bell"></span> </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-cog"></span> </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> </a></li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit"><span
                                    class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="container">
<div class="row">
<div class="col-md-3">
    <div class="panel panel-warning">
        <div class="panel-heading">self</div>
        <div class="panel-body">
            Basic panel example
        </div>
    </div>
</div>
<div class="col-md-6">
<div class="panel panel-primary">
<div class="panel-heading">votes</div>
<div class="panel-body">
<div class="row">
    <div class="col-md-12 inner-col">
        <div class="panel panel-warning">
            <div class="panel-heading vote-pannel-heading">
                <div class="media pull-left">
                    <a class="pull-left" href="#">
                        <img class="media-object img-circle" src="./static/imgs/silencily.jpg"
                             alt="silencily">
                    </a>

                    <div class="media-body">
                        <h5 class="media-heading vote-media-heading">Silencily</h5>
                        <small>2014/06/27 18:02</small>
                    </div>
                </div>
                <div class="vote-actions">
                    <span class="glyphicon glyphicon-hand-up"></span>
                    <span class="badge">777</span>
                    <span class="glyphicon glyphicon-star vote-actions-star" onclick=""></span>
                </div>
            </div>
            <div class="panel-body">
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios1"
                               value="option1">
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2"
                               value="option2">
                        Option two can be something else and selecting it will deselect option one
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios3"
                               value="option3">
                        Option three is disabled
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios4" value="option1"
                               checked>
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 inner-col">
        <div class="panel panel-warning">
            <div class="panel-heading vote-pannel-heading">
                <div class="media pull-left">
                    <a class="pull-left" href="#">
                        <img class="media-object img-circle" src="./static/imgs/silencily.jpg"
                             alt="silencily">
                    </a>

                    <div class="media-body">
                        <h5 class="media-heading vote-media-heading">Silencily</h5>
                        <small>2014/06/27 18:02</small>
                    </div>
                </div>
                <div class="vote-actions">
                    <span class="glyphicon glyphicon-hand-up"></span>
                    <span class="badge">777</span>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </div>
            </div>
            <div class="panel-body">
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios21"
                               value="option1">
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios22"
                               value="option2">
                        Option two can be something else and selecting it will deselect option one
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios23"
                               value="option3">
                        Option three is disabled
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios24" value="option1"
                               checked>
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 inner-col">
        <div class="panel panel-warning">
            <div class="panel-heading vote-pannel-heading">
                <div class="media pull-left">
                    <a class="pull-left" href="#">
                        <img class="media-object img-circle" src="./static/imgs/silencily.jpg"
                             alt="silencily">
                    </a>

                    <div class="media-body">
                        <h5 class="media-heading vote-media-heading">Silencily</h5>
                        <small>2014/06/27 18:02</small>
                    </div>
                </div>
                <div class="vote-actions">
                    <span class="glyphicon glyphicon-hand-up"></span>
                    <span class="badge">777</span>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </div>
            </div>
            <div class="panel-body">
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios31"
                               value="option1">
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios32"
                               value="option2">
                        Option two can be something else and selecting it will deselect option one
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios33"
                               value="option3">
                        Option three is disabled
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios34" value="option1"
                               checked>
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 inner-col">
        <div class="panel panel-warning">
            <div class="panel-heading vote-pannel-heading">
                <div class="media pull-left">
                    <a class="pull-left" href="#">
                        <img class="media-object img-circle" src="./static/imgs/silencily.jpg"
                             alt="silencily">
                    </a>

                    <div class="media-body">
                        <h5 class="media-heading vote-media-heading">Silencily</h5>
                        <small>2014/06/27 18:02</small>
                    </div>
                </div>
                <div class="vote-actions">
                    <span class="glyphicon glyphicon-hand-up"></span>
                    <span class="badge">777</span>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </div>
            </div>
            <div class="panel-body">
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios41"
                               value="option1">
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios42"
                               value="option2">
                        Option two can be something else and selecting it will deselect option one
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios43"
                               value="option3">
                        Option three is disabled
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios44" value="option1"
                               checked>
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
<div class="col-md-3">
    <div class="panel panel-info">
        <div class="panel-heading">news</div>
        <div class="panel-body">
            Basic panel example
        </div>
    </div>
</div>
</div>

</div>
<!-- /container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="./static/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./static/js/bootstrap.js"></script>
</body>
</html>