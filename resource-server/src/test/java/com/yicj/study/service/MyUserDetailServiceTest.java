package com.yicj.study.service;


import com.yicj.study.ResourceServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResourceServerApplication.class)
public class MyUserDetailServiceTest {

    @Autowired
    private UserDetailsService userDetailsService ;

    @Test
    public void loadUserByUsername() {
        String username = "yicj" ;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println(userDetails);
    }
}
