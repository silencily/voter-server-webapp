<!DOCTYPE html>
<html>
<head>
    <title>Voter</title>
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" ><span class="glyphicon glyphicon-cog"></span> </a>
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
            <div class="list-group" id="type-item">
                <a href="${ctx}/discover" class="list-group-item <c:if test="${active eq 'new'}">active</c:if>">
                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                    New votes
                </a>
                <a href="${ctx}/discover/hot" class="list-group-item <c:if test="${active eq 'hot'}">active</c:if>">
                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                    Hot votes
                </a>
                <a href="${ctx}/discover/starred" class="list-group-item <c:if test="${active eq 'starred'}">active</c:if>">
                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                    Starred votes
                </a>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">Votes</div>
                <div class="panel-body vote-panel-body">
                    <c:forEach items="${votes}" var="vote">
                        <div class="row">
                            <div class="col-md-12 inner-col">
                                <div class="panel panel-warning vote-panel">
                                    <div class="panel-heading vote-panel-heading">
                                        <div class="media pull-left">
                                            <a class="pull-left" href="#">
                                                <img class="media-object img-circle"
                                                     src="${ctxStatic}/imgs/silencily.jpg"
                                                     alt="silencily">
                                            </a>

                                            <div class="media-body">
                                                <h5 class="media-heading vote-media-heading">${vote.creatorName}</h5>
                                                <small><fmt:formatDate value="${vote.createTime}"
                                                                       pattern="yyyy/MM/dd HH:mm"/></small>
                                            </div>
                                        </div>
                                        <div class="vote-actions">
                                            <span class="glyphicon glyphicon-hand-up"></span>
                                            <span class="badge">${vote.voted}</span>
                                    <span class="glyphicon glyphicon-star-empty vote-actions-star"
                                          data-voteid="${vote.id}"></span>
                                            <span class="badge">${vote.starred}</span>
                                        </div>
                                    </div>
                                    <div class="panel-body vote-panel-body">
                                        <h4><span class="glyphicon glyphicon-hand-right"></span> ${vote.title}</h4>
                                        <c:choose>
                                            <c:when test="${vote.multi}">
                                                <c:forEach items="${vote.choices}" var="choice">
                                                    <c:if test="${choice.no<5}">
                                                        <div class="checkbox vote-checkbox">
                                                            <span class="vote-order">${choice.no}.</span>
                                                            <label>
                                                                <input type="checkbox"
                                                                       name="checkbox-options-${vote.id}"
                                                                       value="${choice.no}">
                                                                    ${choice.content}
                                                            </label>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${choice.no>=5}">
                                                        <div class="checkbox vote-checkbox hidden">
                                                            <span class="vote-order">${choice.no}.</span>
                                                            <label>
                                                                <input type="checkbox"
                                                                       name="checkbox-options-${vote.id}"
                                                                       value="${choice.no}">
                                                                    ${choice.content}
                                                            </label>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach items="${vote.choices}" var="choice">
                                                    <c:if test="${choice.no<5}">
                                                        <div class="radio vote-radio">
                                                            <span class="vote-order">${choice.no}.</span>
                                                            <label>
                                                                <input type="radio" name="radio-options-${vote.id}"
                                                                       value="${choice.no}">
                                                                    ${choice.content}
                                                            </label>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${choice.no>=5}">
                                                        <div class="radio vote-radio hidden">
                                                            <span class="vote-order">${choice.no}.</span>
                                                            <label>

                                                                <input type="radio" name="radio-options-${vote.id}"
                                                                       value="${choice.no}">
                                                                    ${choice.content}
                                                            </label>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="vote-panel-tools">
                                        <a href="javascript:void(0)"><span class="glyphicon glyphicon-eye-open"></span>
                                            <span>Expand...</span></a>
                                    </div>
                                    <div class="panel-footer vote-panel-footer hidden">
                                        <h4><span class="glyphicon glyphicon-stats"></span> Result</h4>

                                        <div>
                                            <c:forEach items="${vote.choices}" var="choice">
                                                <div class="vote-panel-footer-result">
                                                    <span>${choice.no}.</span>
                                                    <fmt:formatNumber value="${choice.ratio}" type="percent"
                                                                      var="ratio"/>

                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-success"
                                                             role="progressbar"
                                                             aria-valuenow="10"
                                                             aria-valuemin="0"
                                                             aria-valuemax="100" style="width: ${ratio};">
                                                                ${ratio}
                                                        </div>
                                                        <span class="badge  pull-right">${choice.voted}v</span>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <div class="vote-panel-footer-action">
                                            <button type="button" name="vote" data-voteid="${vote.id}"
                                                    class="btn btn-primary btn-block">Vote
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${pagination.nextPageAvailable}">
                        <div class="row" style="padding: 5px 10px;">
                            <a href="${ctx}/discover/<c:if test="${active ne 'new'}">${active}/</c:if>index/1"
                               class="btn btn-default btn-block vote-more"><span
                                    class="glyphicon glyphicon-plus-sign"></span> More</a>
                        </div>
                    </c:if>
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
<script src="${ctxStatic}/js/voter.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAddChoice').click($.voter.appendChoice);
        $('#addVote').click($.voter.pushVote);
        $('.vote-panel-tools a').click($.voter.expendVote);
        $('.vote-actions-star').click($.voter.starVote);
        $("button[name='vote']").click($.voter.voteVote);
        $('.vote-more').click($.voter.loadMoreVote);
    });
</script>
</body>
</html>