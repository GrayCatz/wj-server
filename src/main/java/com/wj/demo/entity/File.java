package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文件
 */
@Getter
@Setter
@Entity
@Table(name = "file")
public class File extends BaseEntity {

    private String name;//文件名
    private String suffix;//后缀
    private String bucket;//桶

}
