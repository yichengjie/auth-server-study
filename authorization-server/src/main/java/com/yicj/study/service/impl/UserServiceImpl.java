package com.yicj.study.service.impl;

import com.yicj.study.dao.UserRepository;
import com.yicj.study.entity.UserEntity;
import com.yicj.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository ;

    @Override
    public UserEntity findUserByName(String username) {
        List<UserEntity> list = repository.findByUsername(username);
        if (list == null || list.isEmpty()){
            return null ;
        }
        return list.get(0);
    }
}
