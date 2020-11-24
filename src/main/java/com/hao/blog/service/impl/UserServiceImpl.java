package com.hao.blog.service.impl;

import com.hao.blog.object.User;
import com.hao.blog.repository.UserRepository;
import com.hao.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        return user;
    }
}
