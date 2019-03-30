package com.ax.entity;

import java.io.Serializable;
import java.util.List;

/** 分页显示 */
public class PageResult implements Serializable {
    private long total; // 总记录数
    private List row; // 每页显示的记录

    public PageResult() {}

    public PageResult(long total, List row) {
        this.total = total;
        this.row = row;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRow() {
        return row;
    }

    public void setRow(List row) {
        this.row = row;
    }
}
