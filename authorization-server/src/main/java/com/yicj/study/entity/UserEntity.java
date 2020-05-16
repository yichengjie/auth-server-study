package com.yicj.study.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private Integer id ;

    @Column(name = "username", nullable = false)
    private String username ;

    @Column(name = "password", nullable = false)
    private String password ;

    @Column(name = "roles")
    private String roles ;
}
