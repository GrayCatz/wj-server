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
@Table(name = "order_image")
public class OrderImage extends BaseEntity {

    private Integer category;//类型 必传：1 非必传 ：2
    private Long imageId;//图片id
    private Long appraisalId;//订单id

}
