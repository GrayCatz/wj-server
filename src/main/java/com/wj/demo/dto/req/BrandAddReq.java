package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
public class BrandAddReq extends BasePageDTO implements Serializable {

    @NotEmpty
    private String name;
    private String remark;

}
