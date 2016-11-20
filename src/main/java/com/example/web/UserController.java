package com.example.web;

import com.example.common.UserStateEnum;
import com.example.domain.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Domg on 2016/11/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    static Map<Long, User> users = new ConcurrentHashMap<>();
/*
    static {
        User u = new User();
        u.setId(10L);
        u.setUserName("lily");
        u.setAge(20);
        u.setState(UserStateEnum.ADMIN.value);
        users.put(u.getId(), u);
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        //处理"/user/"的get请求
        int i = 1 / 0;
        List<User> list = new ArrayList<User>(users.values());
        return list;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        //处理"/user/"的post请求
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setUserName(user.getUserName());
        u.setAge(user.getAge());
        u.setState(user.getState());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        User u = new User();
        u.setUserName("lily");
        int i = 1 / 0;
        return new ModelAndView("index").addObject("user", u);
    }
}
