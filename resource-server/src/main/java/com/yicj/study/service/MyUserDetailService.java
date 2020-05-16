package com.yicj.study.service;

import com.yicj.study.dao.UserRepository;
import com.yicj.study.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名{}",username);
        //根据用户名查找用户信息
        List<UserEntity> list = repository.findByUsername(username);
        if (list ==null || list.isEmpty()){
            throw new UsernameNotFoundException("用户不存在") ;
        }
        UserEntity user = list.get(0);
        //注意这里待分割的角色字符串一定要是‘ROLE_’为前缀
        return new User(username,user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }
}
