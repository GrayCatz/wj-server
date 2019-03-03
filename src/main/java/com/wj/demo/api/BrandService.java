package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.BrandAddReq;
import com.wj.demo.dto.req.BrandPagingReq;
import org.springframework.web.bind.annotation.RequestMapping;

public interface BrandService {

    //分页
    @RequestMapping("/api/v1/brand/paging")
    Response paging(BrandPagingReq dto);

    //详情
    @RequestMapping("/api/v1/brand/get")
    Response get(Long id);

    //详情
    @RequestMapping("/api/v1/brand/add")
    Response add(BrandAddReq dto);

    //详情
    @RequestMapping("/api/v1/brand/remove")
    Response remove(Long id);
}













