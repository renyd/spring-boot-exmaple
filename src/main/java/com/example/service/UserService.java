package com.example.service;

import com.example.domain.User;

/**
 * Created by Domg on 2016/11/19.
 */
public interface UserService {

    User selectByPrimaryKey(Long id);

}
