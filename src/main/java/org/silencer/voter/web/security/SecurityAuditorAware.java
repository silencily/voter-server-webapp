/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.silencer.voter.entity.UserEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author gejb
 * @since 14-8-27
 */
public class SecurityAuditorAware implements AuditorAware<UserEntity> {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public UserEntity getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            if (logger.isWarnEnabled()) {
                logger.warn("security context does not contain authentication.");
            }
            return null;
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null || !(principal instanceof SecurityUser)) {
            if (logger.isWarnEnabled()) {
                logger.warn("Principal [" + principal + "] is invalided.Please be sure you set SecurityUser type to principal.");
            }
            return null;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Current Auditor:" + principal);
        }
        return ((SecurityUser) principal).getUserEntity();
    }
}
