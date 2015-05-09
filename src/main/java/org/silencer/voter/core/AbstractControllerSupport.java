/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    protected void Pagination(Pagination pagination) {
        Pagination pagination1 = pagination;
        if (pagination1.isNotPaginated()) {
            pagination1 = Pagination.NOT_PAGINATED;
        }
        WebContextHolder.setPagination(pagination1);
        if (logger.isDebugEnabled()) {
            logger.debug("the pagination :[" + pagination1 + "] loaded into web context holder.");
        }
    }

}
