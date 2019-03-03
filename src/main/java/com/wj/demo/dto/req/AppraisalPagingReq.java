package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AppraisalPagingReq extends BasePageDTO implements Serializable {

    private String serial;
    private String master;
    private String product;
}
