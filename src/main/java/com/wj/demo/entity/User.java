package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 品牌
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String username;//用户名
    private String password;//密码
    private String portrait;//头像id

}
