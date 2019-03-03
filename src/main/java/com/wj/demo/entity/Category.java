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
@Table(name = "category")
public class Category extends BaseEntity {

    private String name;//名称
    private String brandId;//品牌名称
    private String creator;//品牌名称
}
