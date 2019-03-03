package com.wj.demo.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
//@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Status status = Status.ENABLE;

    //    @CreatedBy
    private Long creatorId;

    @CreatedDate
    private Long createTime;

    private String remark;
    private String creator;//备注

//    public enum Status {
//        DISABLE(0), ENABLE(1);
//        int val;
//        Status(int val) {
//            this.val = val;
//        }
//    }

}
