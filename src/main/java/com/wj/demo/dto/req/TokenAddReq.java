package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class TokenAddReq extends BasePageDTO implements Serializable {

    private String username;
    private String password;

}
