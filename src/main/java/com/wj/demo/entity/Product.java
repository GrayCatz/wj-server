package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 品牌
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String chName;//中文名称
    private String enName;//英文名称
    private String img;//图片id
    private String creator;//图片id
    private Long createTime;//图片id
    private String productTypeId;//产品类型id

    @Enumerated(EnumType.STRING)
    private Status status;//状态

    public enum Status {
        DISABLE, ENABLE
    }

    @OneToOne(cascade = CascadeType.PERSIST)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "brand_id", referencedColumnName = "id", insertable = false, updatable = false)
//people中的address_id字段参考address表中的id字段
    private Brand brand;//发布人id

    @OneToOne(cascade = CascadeType.PERSIST)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
//people中的address_id字段参考address表中的id字段
    private Category category;//发布人id

    @Column(name = "brand_id")
    private Long brandId;//图片id

    @Column(name = "category_id")
    private Long categoryId;//图片id

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    private List<ProductImage> images;//文章列表

}
