/**
 * Created by seven on 2014/7/19.
 */

+function ($) {
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
            '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="_delChoice(this)"><span class="glyphicon glyphicon-trash"> </span></button></span>' +
            '</div>' +
            '</div>';
        $choiceContainer.append(newChoice);
    };
    //发布新投票
    var _pushVote = function () {
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
    }

    $.extend({voter: {}});
    $.extend($.voter, {
        appendChoice: _appendChoice,
        pushVote: _pushVote,
        expendVote: _expendVote,
        starVote: _starVote,
        voteVote: _voteVote
    });


}(jQuery);
