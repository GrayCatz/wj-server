package com.wj.demo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Request implements Serializable {
    private String param;
    private String sign;
}

