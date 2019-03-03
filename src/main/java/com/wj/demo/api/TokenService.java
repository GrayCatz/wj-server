package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.TokenAddReq;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TokenService {

    //分页
    @RequestMapping("/api/v1/token/add")
    Response add(TokenAddReq dto) throws Exception;
}













