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
@Table(name = "appraisal_image")
public class AppraisalImage extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String image;
    private Long appraisalId;

    public enum Type {
        REQUIRED, OPTIONAL
    }
}
