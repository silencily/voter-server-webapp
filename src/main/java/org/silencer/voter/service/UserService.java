/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service;

import org.silencer.voter.entity.UserEntity;

/**
 * @author gejb
 * @since 14-8-26
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param fullname 全名称
     * @param email    邮箱，当作用户名
     * @param password 密码
     * @return 用户实体
     */
    public UserEntity registerUser(String fullname, String email, String password);

    /**
     * 根据用户id查找用户
     *
     * @param id 用户id
     * @return 用户
     */
    public UserEntity findUserById(String id);

    /**
     * 验证密码
     *
     * @param userId   用户id
     * @param password 待验证密码
     * @return true:正确;false:错误
     */
    public boolean validatePassword(String userId, String password);

    /**
     * 改变密码
     * @param userId 用户id
     * @param newPassword 新密码
     */
    public void changePassword(String userId, String newPassword);
}
