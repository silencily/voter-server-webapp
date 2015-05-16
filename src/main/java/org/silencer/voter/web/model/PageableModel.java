/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.model;

import java.util.List;

/**
 * @author gejb
 * @since 2015-05-15
 */
public class PageableModel<T> {
    /**
     * 当前页数
     */
    private int page;
    /**
     * 是否有下一页
     */
    private boolean hasNext;
    /**
     * 页面内容
     */
    private List<T> content;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
