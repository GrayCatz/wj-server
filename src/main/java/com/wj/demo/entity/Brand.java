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
@Table(name = "brand")
public class Brand extends BaseEntity {

    private String chName;//品牌名称
    private String enName;//品牌英文名称
    private String imageId;//图片id
}
