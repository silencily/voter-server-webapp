/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.silencer.voter.core.security.SecurityContextHelper;
import org.silencer.voter.entity.UserEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 控制器基类
 *
 * @author gejb
 * @since 2015-05-09
 */
public abstract class AbstractControllerSupport {
    private static final Log logger = LogFactory.getLog(AbstractControllerSupport.class);

    /**
     * 处理分页数据绑定
     *
     * @param binder
     */
    @InitBinder("pagination")
    protected void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("pagination.");
    }

    @ModelAttribute
    protected Pagination getPagination(Pagination pagination) {
        WebContextHolder.setPagination(pagination);
        if (logger.isDebugEnabled()) {
            logger.debug("the pagination :[" + pagination + "] loaded into web context holder.");
        }
        return pagination;
    }

    /**
     * 获取当前登录用户
     * @return 当前登录用户
     */
    protected UserEntity obtainCurrentUser(){
        return SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
    }

}
