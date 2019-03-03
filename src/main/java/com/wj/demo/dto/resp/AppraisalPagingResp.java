package com.wj.demo.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AppraisalPagingResp implements Serializable {
    private Long id;
    private String serial;
    private String wxSerial;
    private String brand;
    private String product;
    private String creator;
    private String master;
    private String status;
    private String result;
}
