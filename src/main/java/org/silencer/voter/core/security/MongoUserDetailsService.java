/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core.security;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.utils.FormatValidator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
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
        SigninType signinType = decideSigninType(username);
        UserEntity user = null;
        switch (signinType) {
            case PHONE:
                user = mongoTemplate.findOne(Query.query(Criteria.where("phone").is(username)), UserEntity.class);
                break;
            case EMAIL:
                user = mongoTemplate.findOne(Query.query(Criteria.where("email").is(username)), UserEntity.class);
                break;
            case USERNAME:
                break;
        }
        if (user == null) {
            user = mongoTemplate.findOne(Query.query(Criteria.where("username").is(username)), UserEntity.class);
            if (user == null) {
                throw new UsernameNotFoundException("username:'" + username + "' not found.");
            }
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        SecurityUser userDetails = new SecurityUser(user, authorities);
        return userDetails;
    }

    /**
     * 判断登录名的类型
     *
     * @param loginName 登录名
     * @return 登录类型
     */
    private SigninType decideSigninType(String loginName) {
        if (FormatValidator.validateEmail(loginName)) {
            return SigninType.EMAIL;
        }
        if (FormatValidator.validatePhone(loginName)) {
            return SigninType.PHONE;
        }
        return SigninType.USERNAME;

    }

    /**
     * 登录类型：phone,email or username
     */
    private enum SigninType {
        PHONE, EMAIL, USERNAME
    }
}
