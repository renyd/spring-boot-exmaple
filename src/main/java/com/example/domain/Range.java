package com.example.domain;

/**
 * Created by Domg on 2016/12/3.
 */
public class Range extends BaseEntity {

    private String rangeKey;

    private Object start;

    private Object end;

    public String getRangeKey() {
        return rangeKey;
    }

    public void setRangeKey(String rangeKey) {
        this.rangeKey = rangeKey;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }
}
