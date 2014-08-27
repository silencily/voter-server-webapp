/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.security;

import org.silencer.voter.entity.UserEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author gejb
 * @since 14-8-27
 */
public class SecurityAuditorAware implements AuditorAware<UserEntity> {

    @Override
    public UserEntity getCurrentAuditor() {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser.getUserEntity();
    }
}
