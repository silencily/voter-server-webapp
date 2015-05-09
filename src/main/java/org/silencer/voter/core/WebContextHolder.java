/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core;

/**
 * web上下文容器，持有请求中的数据信息
 *
 * @author gejb
 * @since 2015-05-09
 */
public class WebContextHolder {
    /**
     * 分页信息
     */
    private static ThreadLocal<Pagination> pagination = new ThreadLocal<Pagination>();

    public static Pagination getPagination() {
        Pagination pagination1 = pagination.get();
        if (pagination1 == null) {
            pagination1 = Pagination.NOT_PAGINATED;
            pagination.set(pagination1);
        }
        return pagination1;
    }

    public static void setPagination(Pagination pagination1) {
        pagination.set(pagination1);
    }


}
