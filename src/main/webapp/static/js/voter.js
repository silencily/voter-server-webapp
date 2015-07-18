/**
 * Created by seven on 2014/7/19.
 */

+function ($) {
    function _showError(err) {
        $('#error-msg').text(err);
        $('#error-msg').removeClass('hidden');
        $('#error-msg').addClass('show');
    }

    function _clearError() {
        $('#error-msg').text('');
        $('#error-msg').removeClass('show');
        $('#error-msg').addClass('hidden');
    }

    function _alertMessage(msg) {
        $('#message-drawer .message-text').text(msg);
        $('#message-drawer').fadeIn(2000);
        $('#message-drawer').delay(4000).fadeOut(2000);
    }

    function _delChoice(btn) {
        //remove the choice
        $(btn).parents('.list-group-item').remove();
        //刷新choice排序
        $('.vote-modal .list-group').children().each(function (idx, element) {
            $(element).find('.input-group-addon').text(idx + 1);
        });
    }

    //添加新选项
    var _appendChoice = function () {
        var $choiceContainer = $('.vote-modal .list-group');
        var lastChoiceIndex = $choiceContainer.children().length;
        var newChoice = '<div class="list-group-item">' +
            '<div class="input-group input-group-sm ">' +
            '<span class="input-group-addon">' + (lastChoiceIndex + 1) + '</span>' +
            '<input name="choice" type="text" class="form-control">' +
            '<span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-trash"> </span></button></span>' +
            '</div>' +
            '</div>';
        $choiceContainer.append(newChoice);
        $choiceContainer.children(":last").find(':button').click(function () {
            $(this).parents('.list-group-item').remove();
            //刷新choice排序
            $('.vote-modal .list-group').children().each(function (idx, element) {
                $(element).find('.input-group-addon').text(idx + 1);
            });
        })
    };
    //发布新投票
    var _pushVote = function () {
        //获取vote数据
        var title = $('#vote-title').val();
        if (title.trim() == '') {
            _showError('The title is required.');
            $('#vote-title').focus();
            return;
        }
        var multi = $('#isMulti').is(':checked');
        var choices = [];
        var vChoices = true;
        $(':text[name="choice"]').each(function (index, element) {
            var choice = $(element).val();
            if (choice.trim() == '') {
                _showError('The choice is required.');
                $(element).focus();
                vChoices = false;
                return false;
            }
            choices[index] = choice;
        });
        if (!vChoices) {
            return;
        }
        _clearError();
        //ajax post request
        $.post(global.ctx + "/vote", {
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
    }
    //展开投票选项
    var _expendVote = function () {
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
    }
    //标星投票
    var _starVote = function () {
        var $this = $(this);
        var voteId = $this.data('voteid');
        $.post(global.ctx + "/star", {"voteId": voteId}, function (data) {
            var starred = parseInt($this.next().text());
            if ($this.hasClass("glyphicon-star")) {
                $this.next().text(starred - 1);
            } else {
                $this.next().text(starred + 1);
            }
            $this.toggleClass("glyphicon-star");
            $this.toggleClass("glyphicon-star-empty");
        });
    }
    //投票
    var _voteVote = function () {
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
        $.post(global.ctx + "/voted", {"voteId": voteId, "choices": choices}, function (data) {
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
    }
    //加载更多
    var _loadMoreVote = function () {
        var $this = $(this);
        var href = $this.attr("href");
        var nextPage = href.substring(href.lastIndexOf("/") + 1, href.length);
        var paramName = $this.data("param-name");
        var paramValue = $this.data("param-value");
        var postData = {"pagination.page": nextPage};
        if (paramName != null && paramName != "") {
            var strPostData = '{"pagination.page":' + nextPage + ', "' + paramName + '": "' + paramValue + '"}';
            postData = $.parseJSON(strPostData);
        }
        $.post(href, postData, function (data) {
            var page = data.page;
            var hasNext = data.hasNext;
            var content = data.content;
            $.each(content, function (idx, element) {
                var html = '<div class="row">' +
                    '<div class="col-md-12 inner-col">' +
                    '<div class="panel panel-warning vote-panel">' +
                    '<div class="panel-heading vote-panel-heading">' +
                    '<div class="media pull-left">' +
                    '<a class="pull-left" href="#">' +
                    '<img class="media-object img-circle" src="/voter/static/imgs/silencily.jpg" alt="silencily">' +
                    '</a>' +
                    '<div class="media-body">' +
                    '<h5 class="media-heading vote-media-heading">' + element.creatorName + '</h5>' +
                    '<small>' + element.createTime + '</small>' +
                    '</div>' +
                    '</div>' +
                    '<div class="vote-actions">' +
                    '<span class="glyphicon glyphicon-hand-up"></span>' +
                    '<span class="badge">' + element.voted + '</span>';
                var starredBy = element.starredBy;
                if (starredBy) {
                    html += '<span class="glyphicon glyphicon-star vote-actions-star" data-voteid="' + element.id + '"></span>';
                } else {
                    html += '<span class="glyphicon glyphicon-star-empty vote-actions-star" data-voteid="' + element.id + '"></span>';
                }
                html += '<span class="badge">' + element.starred + '</span>' +
                    '</div>' +
                    '</div>' +
                    '<div class="panel-body vote-panel-body">' +
                    '<h4><span class="glyphicon glyphicon-hand-right"></span> ' + element.title + '</h4>';

                var multi = element.multi;
                var votedBy = element.votedBy;
                var choices = element.choices;
                if (multi) {
                    $.each(choices, function (_idx, _element) {
                        var no = _element.no;
                        if (no < 5) {
                            html += '<div class="checkbox vote-checkbox">' +
                                '<span class="vote-order">' + no + '.</span>' +
                                '<label>';
                        } else {
                            //no >=5
                            html += '<div class="checkbox vote-checkbox hidden">' +
                                '<span class="vote-order">' + no + '.</span>' +
                                '<label>';
                        }
                        var choice_votedBy = _element.votedBy;
                        if (choice_votedBy) {
                            if (votedBy) {
                                html += '<input type="checkbox" name="checkbox-options-' + element.id + '" value="' + no + '" checked="checked" disabled="disabled">';
                            } else {
                                html += '<input type="checkbox" name="checkbox-options-' + element.id + '" value="' + no + '" checked="checked">';
                            }
                        } else {
                            if (votedBy) {
                                html += '<input type="checkbox" name="checkbox-options-' + element.id + '" value="' + no + '" disabled="disabled">';
                            } else {
                                html += '<input type="checkbox" name="checkbox-options-' + element.id + '" value="' + no + '">';
                            }
                        }
                        html += _element.content;
                        html += '</label>' +
                            '</div>';
                    });

                } else {
                    $.each(choices, function (_idx, _element) {
                        var no = _element.no;
                        if (no < 5) {
                            html += '<div class="radio vote-radio">' +
                                '<span class="vote-order">' + no + '.</span>' +
                                '<label>';
                        } else {
                            //no >=5
                            html += '<div class="radio vote-radio hidden">' +
                                '<span class="vote-order">' + no + '.</span>' +
                                '<label>';
                        }
                        var choice_votedBy = _element.votedBy;
                        if (choice_votedBy) {
                            if (votedBy) {
                                html += '<input type="radio" name="radio-options-' + element.id + '" value="' + no + '" checked="checked" disabled="disabled">';
                            } else {
                                html += '<input type="radio" name="radio-options-' + element.id + '" value="' + no + '" checked="checked">';
                            }
                        } else {
                            if (votedBy) {
                                html += '<input type="radio" name="radio-options-' + element.id + '" value="' + no + '" disabled="disabled">';
                            } else {
                                html += '<input type="radio" name="radio-options-' + element.id + '" value="' + no + '">';
                            }
                        }
                        html += _element.content;
                        html += '</label>' +
                            '</div>';
                    });
                }
                html += '</div>';
                html += '<div class="vote-panel-tools">' +
                    '<a href="javascript:void(0)"><span class="glyphicon glyphicon-eye-open"></span>' +
                    '<span>Expand...</span></a>' +
                    '</div>';

                html += '<div class="panel-footer vote-panel-footer hidden">' +
                    '<h4><span class="glyphicon glyphicon-stats"></span> Result</h4>' +
                    '<div>';
                $.each(choices, function (idx1, element1) {
                    var ratio = Math.round(element1.ratio * 100) + '%';
                    html += '<div class="vote-panel-footer-result">' +
                        '<span>' + element1.no + '.</span>' +
                        '<div class="progress">' +
                        '<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"' +
                        'style="width: ' + ratio + ';">' + ratio + '</div>' +
                        '<span class="badge  pull-right">' + element1.voted + 'v</span>' +
                        '</div>' +
                        '</div>';
                });
                html += '</div>' +
                    '<div class="vote-panel-footer-action">';
                if (votedBy) {
                    html += '<button type="button" name="vote" data-voteid="' + element.id + '" class="btn btn-primary btn-block" disabled="disabled">Vote</button>';
                } else {
                    html += '<button type="button" name="vote" data-voteid="' + element.id + '" class="btn btn-primary btn-block">Vote</button>';
                }
                html += '</div>';
                html += '</div>' + '</div>' + '</div>' + '</div>';
                $this.parent().before(html);
                $this.parent().prev().find('.vote-panel-tools a').click($.voter.expendVote);
                $this.parent().prev().find('.vote-actions-star').click($.voter.starVote);
                $this.parent().prev().find("button[name='vote']").click($.voter.voteVote);

            });
            if (hasNext) {
                var newHref = href.substring(0, href.lastIndexOf("/") + 1) + (page + 1);
                $this.attr("href", newHref);
            } else {
                $this.parent().remove();
            }
        });
        return false;
    }


    $.extend({voter: {}});
    $.extend($.voter, {
        alertMessage: _alertMessage,
        appendChoice: _appendChoice,
        pushVote: _pushVote,
        expendVote: _expendVote,
        starVote: _starVote,
        voteVote: _voteVote,
        loadMoreVote: _loadMoreVote
    });


}(jQuery);
