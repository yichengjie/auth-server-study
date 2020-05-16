package com.yicj.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @GetMapping("/hello")
    public String hello(){
        return "hello, admin" ;
    }
}