package com.wj.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductStatusUpdateReq implements Serializable {

    private Long id;
    private Status status;

    public enum Status {
        ENABLE, DISABLE
    }
}
