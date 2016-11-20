package com.example.common;

/**
 * Created by Domg on 2016/11/19.
 */
public enum UserStateEnum {

    ADMIN((byte) 0),
    NORMAL((byte) 1),
    DISABLED((byte) 2);

    public final Byte value;

    UserStateEnum(Byte value) {
        this.value = value;
    }
}
