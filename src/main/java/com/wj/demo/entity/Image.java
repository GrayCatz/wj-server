package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * 文件
 */
@Getter
@Setter
@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    private String name;//文件名
    @Enumerated(EnumType.STRING)
    private Type type;//
    private String url;//

    public enum Type {
        PRODUCT,//产品图
        PRODUCT_EXAMPLE,//产品鉴别图标
        PRODUCT_REAL_EXAMPLE//产品鉴别示例图
    }

}
