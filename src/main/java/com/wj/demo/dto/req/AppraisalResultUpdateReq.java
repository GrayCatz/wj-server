package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AppraisalResultUpdateReq extends BasePageDTO implements Serializable {

    private Long id;
    private Result result;

    public enum Result {
        INITIAL, REAL, FAKE, ILLEGAL
    }
}
