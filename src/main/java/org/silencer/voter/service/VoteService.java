/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service;

import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.web.security.SecurityUser;

import java.util.List;

/**
 * @author gejb
 * @since 14-8-26
 */
public interface VoteService {
    /**
     * 根据用户加载投票<br>
     * 初始加载按照系统<code>system.pagesize.initload</code>设置限制查询数量
     *
     * @param userId 用户
     * @return 投票集合
     */
    public List<VoteEntity> initLoadVoteByUserId(String userId);

    /**
     * 新增vote
     * @param title 标题
     * @param multi 是否多选
     * @param choices 选项
     */
    public void addVote(String title, boolean multi, String[] choices);
}
