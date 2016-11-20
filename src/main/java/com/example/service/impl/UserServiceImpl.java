package com.example.service.impl;

import com.example.domain.User;
import com.example.domain.mapper.UserMapper;
import com.example.service.UserService;

import javax.annotation.Resource;

/**
 * Created by Domg on 2016/11/19.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
