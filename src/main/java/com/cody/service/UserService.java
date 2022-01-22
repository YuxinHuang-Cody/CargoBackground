package com.cody.service;

import com.cody.dao.UserDAO;
import com.cody.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/13
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User getByName(String name) {
        return userDAO.findByName(name);
    }
}
