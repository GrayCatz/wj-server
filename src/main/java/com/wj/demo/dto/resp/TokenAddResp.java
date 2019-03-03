package com.wj.demo.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class TokenAddResp implements Serializable {
    private String username;
    private String token;

    public TokenAddResp() {
    }

    public TokenAddResp(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
