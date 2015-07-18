<!DOCTYPE html>
<html>
<head>
    <title>Voter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap.css">
    <link rel="stylesheet" href="${ctxStatic}/css/voter.css">
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrapValidator.css">
    <link rel="shortcut icon" href="${ctxStatic}/imgs/favicon.ico">

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
                <li><a href="${ctx}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="${ctx}/discover"><span class="glyphicon glyphicon-globe"></span> Discover</a></li>
                <li><a href="${ctx}/me"><span class="glyphicon glyphicon-user"></span> Me</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/notification"><span class="glyphicon glyphicon-bell"></span> </a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span
                            class="glyphicon glyphicon-cog"></span> </a>
                    <ul class="dropdown-menu setting-menu" role="menu">
                        <li><a href="${ctx}/profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        <li><a href="${ctx}/password"><span class="glyphicon glyphicon-lock"></span> Password</a></li>
                        <li class="divider"></li>
                        <li><a href="${ctx}/logout"><span class="glyphicon glyphicon-off"></span> Logout</a></li>
                    </ul>
                </li>
                <li><a href="#newVote" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span> </a></li>
            </ul>
            <form class="navbar-form navbar-right" action="${ctx}/search" role="search">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" name="s" placeholder="Search">
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
<div class="alert-messages" id="message-drawer" style="display: none;">
    <div class="message bg-info">
        <div class="message-inside">
            <span class="message-text"></span>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="newVote" tabindex="-1" role="dialog" aria-labelledby="newVoteLabel" aria-hidden="true">
    <div class="modal-dialog vote-modal">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="newVoteLabel">Compose new Vote</h4>

                <div id="error-msg" class="alert alert-danger hidden" role="alert">error message.</div>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row" style="padding-bottom: 5px;border-bottom: 1px solid #e5e5e5;">
                        <div class="col-sm-12">
                            <div class="checkbox" style="display: inline">
                                <label>
                                    <input id="isMulti" type="checkbox"> Multi
                                </label>
                            </div>
                            <button id="btnAddChoice" type="button" class="btn btn-primary btn-xs pull-right"><span
                                    class="glyphicon glyphicon-plus"></span> Add Choice
                            </button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12" style="padding-top: 5px;padding-bottom: 5px;">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Title</span>
                                <input id="vote-title" type="text" class="form-control"
                                       placeholder="Enter the Title for your vote.">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="list-group">
                                <div class="list-group-item">
                                    <div class="input-group input-group-sm ">
                                        <span class="input-group-addon">1</span>
                                        <input name="choice" type="text" class="form-control">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" disabled="disabled"><span
                                                    class="glyphicon glyphicon-trash"> </span></button>
                                        </span>
                                    </div>
                                </div>
                                <div class="list-group-item">
                                    <div class="input-group input-group-sm ">
                                        <span class="input-group-addon">2</span>
                                        <input name="choice" type="text" class="form-control">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" disabled="disabled"><span
                                                    class="glyphicon glyphicon-trash"> </span></button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
            <div class="modal-footer">
                <button id="addVote" type="button" class="btn btn-primary"><span
                        class="glyphicon glyphicon-send"></span> Vote
                </button>
            </div>
        </div>
    </div>
</div>

<div class="container">
<div class="row">
<div class="col-md-3">
    <div class="panel panel-warning">
        <div class="panel-heading">
            <div class="media">
                <a class="pull-left" href="#">
                    <img class="media-object img-rounded vote-self-img" src="${ctxStatic}/imgs/silencily.jpg"
                         alt="silencily">
                </a>

                <div class="media-body vote-self-name">
                    <h4 class="media-heading vote-media-heading">${currentUser.fullname}</h4>
                </div>
            </div>
        </div>
        <div class="panel-body vote-self-info">
            <ul class="list-group">
                <li class="list-group-item">
                    <span class="glyphicon glyphicon-user"></span> ${currentUser.username}
                </li>
                <li class="list-group-item">
                    <span class="glyphicon glyphicon-envelope"></span> ${currentUser.email}
                </li>
                <li class="list-group-item">
                    <span class="glyphicon glyphicon-time"></span> Joined on <fmt:setLocale value="en_US"/>
                    <fmt:formatDate value="${currentUser.joinedDate}"/>
                </li>
            </ul>
        </div>
        <div class="panel-footer" style="padding: 0px;">
            <div class="list-group" id="type-item" style="margin-bottom: 0px;">
                <a href="${ctx}/profile" class="list-group-item">
                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                    Profile
                </a>
                <a href="${ctx}/password" class="list-group-item active">
                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                    Password
                </a>
            </div>
        </div>
    </div>
</div>
<div class="col-md-6">
<div class="panel panel-primary">
<div class="panel-heading">Password</div>
<div class="panel-body">
    <form id="changePasswordForm" action="${ctx}/password" class="form-horizontal" method="post">
        <div class="form-group" style="margin-bottom: 0px;">
            <label for="oldPassword" class="col-sm-4 control-label">Current Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="Current Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-6">
                <a href="#">Forget your password?</a>
            </div>
        </div>

        <div class="form-group">
            <label for="newPassword" class="col-sm-4 control-label">New Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="New Password">
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword" class="col-sm-4 control-label">Confirm Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
            </div>
        </div>
        <div class="form-group" style="margin-top: 60px;padding-top: 20px;border-top: 1px solid #ccc;">
            <div class="col-sm-12" style="text-align: center;">
                <button type="submit" class="btn btn-primary">
                    <span class="glyphicon glyphicon-floppy-save"></span> Save changes
                </button>
            </div>
        </div>
    </form>
</div>
</div>
</div>
<div class="col-md-3">
    <div class="panel panel-info">
        <div class="panel-heading">news</div>
        <div class="panel-body">
            This is a news panel.
        </div>
    </div>
</div>
</div>

</div>
<!-- /container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctxStatic}/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctxStatic}/js/bootstrap.js"></script>

<script src="${ctxStatic}/js/bootstrapValidator.js"></script>
<script src="${ctxStatic}/js/voter.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAddChoice').click($.voter.appendChoice);
        $('#addVote').click($.voter.pushVote);

        $('#changePasswordForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitHandler: function(validator, form, submitButton) {
                // Use Ajax to submit form data
                $.post(form.attr('action'), form.serialize(), function(result) {
                    $.voter.alertMessage('Change new password successful.');
                    $('#changePasswordForm').data('bootstrapValidator').resetForm(true);
                }, 'json');
            },
            fields: {
                oldPassword: {
                    validators: {
                        notEmpty: {
                            message: 'The Current Password is required and cannot be empty'
                        }
                    }
                },
                newPassword: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and cannot be empty'
                        },
                        different: {
                            field: 'oldPassword',
                            message: 'The new password and current password cannot be the same as each other'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and cannot be empty'
                        },
                        identical: {
                            field: 'newPassword',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>