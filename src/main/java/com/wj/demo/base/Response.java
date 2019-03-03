package com.wj.demo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Response implements Serializable {
    private String code = "1";
    private String msg ="OK";
    private Object data;

    public Response() {
    }

    public Response(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(Object data) {
        this.data = data;
    }
}
