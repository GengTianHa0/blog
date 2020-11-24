package com.hao.blog.service;

import com.hao.blog.object.User;

public interface UserService {
    User checkUser(String username, String password);

}
