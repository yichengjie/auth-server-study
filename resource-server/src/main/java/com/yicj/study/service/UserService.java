package com.yicj.study.service;

import com.yicj.study.entity.UserEntity;

public interface UserService {

    UserEntity findUserByName(String username) ;
}
