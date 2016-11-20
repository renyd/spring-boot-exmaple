package com.example.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Domg on 2016/11/19.
 */
public class BaseEntity {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
