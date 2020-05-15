package com.yicj.study.controller;

import com.yicj.study.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestAPI {

    @RequestMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = new ArrayList<>() ;
        users.add(new User("kevin",33)) ;
        users.add(new User("joe", 30)) ;
        return ResponseEntity.ok(users) ;
    }
}
