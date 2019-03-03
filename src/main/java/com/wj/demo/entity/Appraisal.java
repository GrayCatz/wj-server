package com.wj.demo.entity;


import com.wj.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 鉴定单
 */
@Getter
@Setter
@Entity
@Table(name = "appraisal")
public class Appraisal extends BaseEntity {

    @Column(columnDefinition="VARCHAR(255) COMMENT '订单号'")
    private String serial;//订单号
    @Column(columnDefinition="VARCHAR(255) COMMENT '微信订单号'")
    private String wxSerial;//订单号
    @Column(columnDefinition="VARCHAR(255) COMMENT '备注'")
    private String remark;//备注
    //    private Long brandId;//鉴别师id
//    private Long masterId;//鉴别师id
//    private Long productId;//产品id
    @Column(columnDefinition="BIGINT(20) COMMENT '发布人id'")
    private Long userId;//发布人id
    @Column(columnDefinition="VARCHAR(255) COMMENT '鉴别结果 INITIAL:待鉴定 REAL:假 FAKE：真'")
    private Result result;//鉴别结果 INITIAL:待鉴定 REAL:假 FAKE：真
    @Column(columnDefinition="VARCHAR(255) COMMENT '状态 INITIAL：待鉴定  DONE：鉴定完成 REFUSE：拒绝鉴定'")
    private Status status;//状态 INITIAL：待鉴定  DONE：鉴定完成 REFUSE：拒绝鉴定

    public String getResultText() {
        switch (result) {
            case INITIAL:
                return "待鉴定";
            case REAL:
                return "真";
            case FAKE:
                return "假";
            case ILLEGAL:
                return "违规";
        }
        return "";
    }

    public enum Result {
        INITIAL, REAL, FAKE, ILLEGAL
    }

    public enum Status {
        INITIAL, DONE, REFUSE
    }

    @OneToOne(cascade = CascadeType.PERSIST)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "product_id", referencedColumnName = "id")//people中的address_id字段参考address表中的id字段
    private Product product;//发布人id

    @OneToOne(cascade = CascadeType.PERSIST)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "master_id", referencedColumnName = "id")//people中的address_id字段参考address表中的id字段
    private Master master;//发布人id


    @OneToMany(mappedBy = "appraisalId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
//    拥有mappedBy注解的实体类为关系被维护端
//    mappedBy="author"中的author是Article中的author属性
    private List<AppraisalImage> images;//文章列表

    public String getStatusText() {
        switch (status) {
            case DONE:
                return "鉴定完成";
            case REFUSE:
                return "拒绝鉴定";
            case INITIAL:
                return "待鉴定";
        }
        return "";
    }
}
