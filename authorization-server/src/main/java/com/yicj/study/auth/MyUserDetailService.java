package com.yicj.study.auth;

import com.yicj.study.entity.UserEntity;
import com.yicj.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名{}",username);
        //根据用户名查找用户信息
        //注意这里待分割的角色字符串一定要是‘ROLE_’为前缀
        UserEntity user = userService.findUserByName(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在") ;
        }
        return new User(username,user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }
}
