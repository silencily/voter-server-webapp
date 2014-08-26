/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.security;

import org.silencer.voter.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息从mongodb中读取组装
 *
 * @author gejb
 * @since 14-8-25
 */
public class MongoUserDetailsService implements UserDetailsService {

    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query(Criteria.where("username").is(username));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        if (user == null) {

        }
        if (user == null) {
            throw new UsernameNotFoundException("username:'" + username + "' not found.");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        User userDetails = new User(username, user.getPassword(), user.isEnabled(), true, true, true, authorities);
        return userDetails;
    }

    /**
     * 判断登录名的类型
     *
     * @param loginName 登录名
     * @return 登录类型
     */
    private SigninType decideSigninType(String loginName) {

        return SigninType.USERNAME;

    }

    /**
     * 登录类型：phone,email or username
     */
    private enum SigninType {
        PHONE, EMAIL, USERNAME
    }
}
