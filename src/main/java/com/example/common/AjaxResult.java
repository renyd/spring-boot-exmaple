package com.example.common;

import com.example.domain.BaseEntity;

/**
 * Created by Domg on 2016/11/20.
 */
public class AjaxResult extends BaseEntity {

    private String code;
    private String message;
    private Object data;

    public AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
