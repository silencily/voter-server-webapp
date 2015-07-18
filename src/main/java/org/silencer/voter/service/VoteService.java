/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service;

import org.silencer.voter.entity.VoteEntity;

import java.util.List;

/**
 * @author gejb
 * @since 14-8-26
 */
public interface VoteService {
    /**
     * 查询home页面投票
     *
     * @param userId 用户
     * @return 投票集合
     */
    public List<VoteEntity> queryHomeVotes(String userId);

    /**
     * 新增vote
     *
     * @param title   标题
     * @param multi   是否多选
     * @param choices 选项
     */
    public void addVote(String title, boolean multi, String[] choices);

    /**
     * 验证是否为用户所标记星
     *
     * @param voteId voteid
     * @param userId 用户id
     * @return true:标记星；false：未标记星
     */
    public boolean checkStarredBy(String voteId, String userId);

    /**
     * 切换标记星
     *
     * @param voteId voteId
     * @param userId 用户id
     */
    public void toggleStar(String voteId, String userId);

    /**
     * 获取投票选择的选项号
     *
     * @param voteId voteId
     * @param userId 用户id
     * @return 投票选择的选项号
     */
    public List<Integer> obtainVotedChoices(String voteId, String userId);

    /**
     * 投票
     *
     * @param voteId  voteId
     * @param choices 投票选择的号
     * @param userId  用户id
     * @return 投票选择结果
     */
    public List<VoteEntity.Choice> voted(String voteId, Integer[] choices, String userId);

    /**
     * 发现新投票，按照创建时间进行降序，排除当前登录人参与过的
     *
     * @param userId 排除的用户id
     * @return 投票集合
     */
    public List<VoteEntity> discoverNewVotes(String userId);

    /**
     * 发现热门投票，按照投票数量进行降序，排除当前登录人参与过的
     *
     * @param userId 排除的用户id
     * @return 投票集合
     */
    public List<VoteEntity> discoverHotVotes(String userId);

    /**
     * 发现标星投票，按照标星数量进行降序，排除当前登录人参与过的
     *
     * @param userId 排除的用户id
     * @return 投票集合
     */
    public List<VoteEntity> discoverStarredVotes(String userId);

    /**
     * 查询自己发起的投票，按照创建时间进行降序
     *
     * @param userId 用户id
     * @return 投票集合
     */
    public List<VoteEntity> queryMeVotes(String userId);

    /**
     * 查询自己参与投票的投票，按照投票时间进行降序
     *
     * @param userId 用户id
     * @return 投票集合
     */
    public List<VoteEntity> queryMeVotedVotes(String userId);

    /**
     * 查询自己标星投票，按照标星时间进行降序
     *
     * @param userId 用户id
     * @return 投票集合
     */
    public List<VoteEntity> queryMeStarredVotes(String userId);

    /**
     * 根据关键词查找投票
     * @param key 关键词
     * @return 投票集合
     */
    public List<VoteEntity> searchVotes(String key);


}
