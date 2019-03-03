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
@Table(name = "token")
public class Token extends BaseEntity {

    private Long userId;//
    private Long expired;//
    private Status status;//
    private String ticket;//

    public enum Status {
        ENABLE, DISABLE
    }
}
