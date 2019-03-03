package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * 品牌
 */
@Getter
@Setter
@Entity
@Table(name = "product_image")
public class ProductImage extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String example;
    private String realExample;
    private Long productId;

    public enum Type {
        REQUIRED, OPTIONAL
    }
}
