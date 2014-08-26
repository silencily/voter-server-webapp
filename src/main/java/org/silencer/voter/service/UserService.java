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
     * @param fullname 全名称
     * @param email 邮箱，当作用户名
     * @param password 密码
     * @return 用户实体
     */
    public UserEntity registerUser(String fullname, String email, String password);
}
