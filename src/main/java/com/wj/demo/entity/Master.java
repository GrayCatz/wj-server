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
@Table(name = "master")
public class Master extends BaseEntity {

    private String name;//名称
    private String brands;//可鉴定品牌
    private String requirement;//要求
    private String userId;//用户id

}
