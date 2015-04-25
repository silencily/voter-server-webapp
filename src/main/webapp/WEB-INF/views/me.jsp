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
                <li><a href="#"><span class="glyphicon glyphicon-bell"></span> </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-cog"></span> </a></li>
                <li><a href="#newVote" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span> </a></li>
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
    </div>
</div>
<div class="col-md-6">
<div class="panel panel-primary">
<div class="panel-heading me-nav">
    <ul class="nav nav-pills" role="tablist">
        <li role="presentation" class=""><a class="in" href="#">Votes <span class="badge">${currentUser.voteCounter.votes}</span></a></li>
        <li role="presentation" class=""><a href="#">Voted <span class="badge">${currentUser.voteCounter.voted}</span></a></li>
        <li role="presentation" class=""><a href="#">Starred <span class="badge">${currentUser.voteCounter.starred}</span></a></li>
    </ul>
</div>
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
        <c:choose>
            <c:when test="${vote.starredBy}">
                                                    <span class="glyphicon glyphicon-star vote-actions-star"
                                                          data-voteid="${vote.id}"></span>
            </c:when>
            <c:otherwise>
                                                    <span class="glyphicon glyphicon-star-empty vote-actions-star"
                                                          data-voteid="${vote.id}"></span>
            </c:otherwise>
        </c:choose>
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
                            <c:if test="${choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" checked="checked"
                                           disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" checked="checked">
                                </c:if>
                            </c:if>
                            <c:if test="${not choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}">
                                </c:if>
                            </c:if>
                                ${choice.content}
                        </label>
                    </div>
                </c:if>
                <c:if test="${choice.no>=5}">
                    <div class="checkbox vote-checkbox hidden">
                        <span class="vote-order">${choice.no}.</span>
                        <label>
                            <c:if test="${choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" checked="checked"
                                           disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" checked="checked">
                                </c:if>
                            </c:if>
                            <c:if test="${not choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}" disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="checkbox"
                                           name="checkbox-options-${vote.id}"
                                           value="${choice.no}">
                                </c:if>
                            </c:if>
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
                            <c:if test="${choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" checked="checked"
                                           disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" checked="checked">
                                </c:if>
                            </c:if>
                            <c:if test="${not choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}">
                                </c:if>
                            </c:if>
                                ${choice.content}
                        </label>
                    </div>
                </c:if>
                <c:if test="${choice.no>=5}">
                    <div class="radio vote-radio hidden">
                        <span class="vote-order">${choice.no}.</span>
                        <label>
                            <c:if test="${choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" checked="checked"
                                           disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" checked="checked">
                                </c:if>
                            </c:if>
                            <c:if test="${not choice.votedBy}">
                                <c:if test="${vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}" disabled="disabled">
                                </c:if>
                                <c:if test="${not vote.votedBy}">
                                    <input type="radio"
                                           name="radio-options-${vote.id}"
                                           value="${choice.no}">
                                </c:if>
                            </c:if>
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
        <c:if test="${vote.votedBy}">
            <button type="button" name="vote" data-voteid="${vote.id}"
                    class="btn btn-primary btn-block" disabled="disabled">Vote
            </button>
        </c:if>
        <c:if test="${not vote.votedBy}">
            <button type="button" name="vote" data-voteid="${vote.id}"
                    class="btn btn-primary btn-block">Vote
            </button>
        </c:if>

    </div>
</div>
</div>
</div>
</div>
</c:forEach>
<div class="row">
    <div class="panel-footer">Auto loading...</div>
</div>
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

<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAddChoice').click(function () {
            var $choiceContainer = $('.vote-modal .list-group');
            var lastChoiceIndex = $choiceContainer.children().length;
            var newChoice = '<div class="list-group-item">' +
                    '<div class="input-group input-group-sm ">' +
                    '<span class="input-group-addon">' + (lastChoiceIndex + 1) + '</span>' +
                    '<input name="choice" type="text" class="form-control">' +
                    '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="delChoice(this)"><span class="glyphicon glyphicon-trash"> </span></button></span>' +
                    '</div>' +
                    '</div>';
            $choiceContainer.append(newChoice);
        });
        $('#addVote').click(function () {
            //获取vote数据
            var title = $('#vote-title').val();
            if (title.trim() == '') {
                showError('The title is required.');
                $('#vote-title').focus();
                return;
            }
            var multi = $('#isMulti').is(':checked');
            var choices = [];
            var vChoices = true;
            $(':text[name="choice"]').each(function (index, element) {
                var choice = $(element).val();
                if (choice.trim() == '') {
                    showError('The choice is required.');
                    $(element).focus();
                    vChoices = false;
                    return false;
                }
                choices[index] = choice;
            });
            if (!vChoices) {
                return;
            }
            clearError();
            //ajax post request
            $.post("${ctx}/vote", {
                "title": title,
                "multi": multi,
                "choices": choices
            }, function (data, txtStatus, jqXHR) {
                $('#newVote').modal('hide');
                $('#vote-title').val('');
                $('#isMulti').attr("checked", false);
                $(':text[name="choice"]').each(function (index, element) {
                    if (index > 1) {
                        $(element).parents('.list-group-item').remove();
                    } else {
                        $(element).val('');
                    }
                });
                $('#message-drawer .message-text').text(data);
                $('#message-drawer').fadeIn(2000);
                $('#message-drawer').delay(4000).fadeOut(2000);
            });
        });

        $('.vote-panel-tools a').click(function () {
            var isOpen = $(this).children('span').hasClass('glyphicon-eye-open');
            if (isOpen) {
                $(this).children('span').first().removeClass('glyphicon-eye-open');
                $(this).children('span').first().addClass('glyphicon-eye-close');
                $(this).children('span').last().text('Collapse...');
                $(this).parent().prev().children('div.hidden').removeClass('hidden').addClass('show');
            } else {
                $(this).children('span').first().removeClass('glyphicon-eye-close');
                $(this).children('span').first().addClass('glyphicon-eye-open');
                $(this).children('span').last().text('Expand...');
                $(this).parent().prev().children('div.show').removeClass('show').addClass('hidden');
            }
            $(this).parent().next().toggleClass('hidden');
        });
        $('.vote-actions-star').click(function () {
            var $this = $(this);
            var voteId = $this.data('voteid');
            $.post("${ctx}/star", {"voteId": voteId}, function (data) {
                var starred = parseInt($this.next().text());
                if ($this.hasClass("glyphicon-star")) {
                    $this.next().text(starred - 1);
                } else {
                    $this.next().text(starred + 1);
                }
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            });
        });
        $("button[name='vote']").click(function () {
            var $this = $(this);
            var voteId = $this.data('voteid');
            var choices = [];
            $this.parents('.vote-panel').find("input[name$='-options-" + voteId + "']:checked").each(function (idx, element) {
                choices[idx] = $(element).val();
            });
            if (choices.length == 0) {
                alert('please chose your vote.');
                return false;
            }
            $.post("${ctx}/voted", {"voteId": voteId, "choices": choices}, function (data) {
                $this.parents('.vote-panel').find("input[name$='-options-" + voteId + "']").attr("disabled", "disabled");
                $this.attr("disabled", "disabled");
                var voted = $this.parents('.vote-panel').find(".vote-actions .glyphicon-hand-up").next().text();
                var voted2 = parseInt(voted) + 1;
                $this.parents('.vote-panel').find(".vote-actions .glyphicon-hand-up").next().text(voted2);
                $.each(data, function (idx, element) {
                    var radio = element.ratio;
                    var voted = element.voted;
                    var result = $this.parent().prev().children(".vote-panel-footer-result")[idx];
                    $(result).find(".progress-bar").attr("style", "width:" + radio * 100 + "%").text(radio * 100 + "%").next().text(voted + "v");

                });

            });
        });
    });
    function showError(err) {
        $('#error-msg').text(err);
        $('#error-msg').removeClass('hidden');
        $('#error-msg').addClass('show');
    }
    function clearError() {
        $('#error-msg').text('');
        $('#error-msg').removeClass('show');
        $('#error-msg').addClass('hidden');
    }

    function delChoice(btn) {
        //remove the choice
        $(btn).parents('.list-group-item').remove();
        //刷新choice排序
        $('.vote-modal .list-group').children().each(function (idx, element) {
            $(element).find('.input-group-addon').text(idx + 1);
        });
    }
</script>
</body>
</html>