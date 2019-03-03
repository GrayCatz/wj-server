package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.ProductAddReq;
import com.wj.demo.dto.req.ProductPagingReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ProductService {

    //分页
    @RequestMapping("/api/v1/product/paging")
    Response paging(ProductPagingReq dto);

    //详情
    @RequestMapping("/api/v1/product/get")
    Response get(Long id) throws Exception;

    //详情
    @RequestMapping("/api/v1/product/remove")
    Response remove(Long id) throws Exception;


    //详情
    @RequestMapping("/api/v1/product/add")
    Response add(@RequestBody ProductAddReq req);

    //详情
    @RequestMapping("/api/v1/product/save")
    Response save(@RequestBody ProductAddReq req) throws Exception;

//    //详情
//    @RequestMapping("/api/v1/product/update")
//    Response update(String data);
}













