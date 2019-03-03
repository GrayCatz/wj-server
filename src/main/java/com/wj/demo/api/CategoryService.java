package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.CategoryAddReq;
import com.wj.demo.dto.req.CategoryPagingReq;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public interface CategoryService {

    //分页
    @RequestMapping("/api/v1/category/paging")
    Response paging(CategoryPagingReq dto);

    //详情
    @RequestMapping("/api/v1/category/get")
    Response get(Long id);

    @RequestMapping("/api/v1/category/add")
    Response add(@Valid CategoryAddReq dto);

    @RequestMapping("/api/v1/category/remove")
    Response remove(Long id);
}













