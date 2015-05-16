/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core;

import java.io.Serializable;

/**
 * 用于页面分页的帮助类, 保存当前页面数据的所有行数, 每页行数, 当前页等属性. 这个类通常用于从前端 请求参数中组装当前页数(基于<b>0</b>),
 * 每页行数等属性. 把这个类放到这里是因为底层的服务必须对 性能和容量问题提供解决方案, 而且虽然这个类主要用于前端但没有附加任何表现层的特征,
 * 所以在特定的 条件下也可以支持后端的处理
 *
 * @author gejb
 * @since 2015-05-09
 */
public class Pagination implements Serializable {

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final String CONFIG_PAGESIZE_KEY = "system.pagesize";

    /**
     * 每页行数, 通常在页面中可以修改这个参数
     */
    private int pageSize = ConfigurationContainer.getContainer().getInteger(CONFIG_PAGESIZE_KEY, DEFAULT_PAGE_SIZE);

    /**
     * 当前是第几页, 从<b>0</b>开始计算
     */
    private int page;

    /**
     * 所有的行数
     */
    private int count;

    /**
     * 不执行分页操作的标志, 除非设置了这个实例的分页标志. 否则不应该对这个实例执行分页.
     *
     * @see #setCount(int)
     * @see #setPage(int)
     * @see #setPageSize(int)
     */
    private boolean notPaginated = true;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.notPaginated = false;
        if (this.pageSize < 1) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }

    /**
     * 返回一页中表现多少行数据
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置当前实例在第<code>page</code>页
     */
    public void setPage(int page) {
        this.notPaginated = false;
        this.page = page;
    }

    /**
     * 返回当前实例在第几页
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前实例共有多少行数据
     */
    public void setCount(int count) {
        this.count = count;
        this.notPaginated = false;
    }

    /**
     * 返回所有的数据行数
     */
    public int getCount() {
        return count;
    }

    /**
     * 返回当前实例总共的页数, 如果没有数据返回<b>0</b>, 如果数据不足一页返回<b>1</b>
     *
     * @return 当前实例总共的页数
     */
    public final int getPageCount() {
        int remainder = count % pageSize;
        if (count != 0 && remainder == count) {
            return 1;
        } else if (remainder == 0) {
            return (count / pageSize);
        } else {
            return (count / pageSize) + 1;
        }
    }

    /**
     * 判断是否是第一页, 如果当前实例没有数据或只有一页返回<code>true</code>
     *
     * @return
     */
    public boolean isFirst() {
        return getPageCount() < 2 || page == 0;
    }

    /**
     * 判断是否是最后一页, 如果当前实例没有数据或只有一页返回<code>true</code>
     *
     * @return 是否是最后一页
     */
    public boolean isLast() {
        return (getPageCount() < 2) || (page == (getPageCount() - 1));
    }

    /**
     * 判断是否存在上一页
     */
    public boolean isPreviousPageAvailable() {
        return getPageCount() > 1 && page > 0;
    }

    /**
     * 判断是否存在下一页
     */
    public boolean isNextPageAvailable() {
        return getPageCount() > 1 && page < getPageCount() - 1;
    }

    public boolean isNotPaginated() {
        return this.notPaginated;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageSize=" + pageSize +
                ", page=" + page +
                ", count=" + count +
                ", notPaginated=" + notPaginated +
                '}';
    }
}
