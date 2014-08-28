/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.silencer.voter.entity.UserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gejb
 * @since 14-8-28
 */
public class SecurityContextHelper {
    private static final Log logger = LogFactory.getLog(SecurityContextHelper.class);

    /**
     * The default key under which the security context will be stored in the session.
     */
    public static final String SPRING_SECURITY_CONTEXT_KEY = "SPRING_SECURITY_CONTEXT";

    /**
     * 认证用户，主要用于成功注册用户的认证，自动将其身份认证为合法，
     * 这样可以通过安全过滤器的拦截，不需要再进行登录操作
     *
     * @param userEntity 用户实体
     * @param request    http request
     * @return 成功的认证
     */
    public static Authentication authenticate(UserEntity userEntity, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        SecurityContext context = null;
        Object contextFromSession = httpSession.getAttribute(SPRING_SECURITY_CONTEXT_KEY);

        if (contextFromSession == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("HttpSession returned null object for SPRING_SECURITY_CONTEXT");
            }
        } else {
            // We now have the security context object from the session.
            if (!(contextFromSession instanceof SecurityContext)) {
                if (logger.isWarnEnabled()) {
                    logger.warn(SPRING_SECURITY_CONTEXT_KEY + " did not contain a SecurityContext but contained: '"
                            + contextFromSession + "'; are you improperly modifying the HttpSession directly "
                            + "(you should always use SecurityContextHolder) or using the HttpSession attribute "
                            + "reserved for this class?");
                }
            } else {
                context = (SecurityContext) contextFromSession;
            }
        }
        if (context == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("create empty context.");
            }
            context = SecurityContextHolder.createEmptyContext();
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        SecurityUser securityUser = new SecurityUser(userEntity, authorities);
        Authentication authentication = new UsernamePasswordAuthenticationToken(securityUser, userEntity.getPassword(), securityUser.getAuthorities());
        //set authenticated authentication into security context
        context.setAuthentication(authentication);
        //set SPRING_SECURITY_CONTEXT_KEY into session for ensuring to pass authentication of security filters next
        httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);
        return authentication;
    }
}
