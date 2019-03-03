package com.wj.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private String code = "0";
    private String msg = "";

    public ApiException(String message) {
        super(message);
        this.msg = message;
    }

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }
}
