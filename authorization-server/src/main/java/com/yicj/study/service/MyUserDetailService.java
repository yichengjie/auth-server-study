package com.yicj.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名{}",username);
        //根据用户名查找用户信息
        //注意这里待分割的角色字符串一定要是‘ROLE_’为前缀
        return new User(username,"123",
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
