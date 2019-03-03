package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.ImageAddReq;
import com.wj.demo.dto.req.ImageBatchAddReq;
import com.wj.demo.dto.req.ImagePagingReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ImageService {

    //分页
    @RequestMapping("/api/v1/image/paging")
    Response paging(ImagePagingReq dto);

    //详情
    @RequestMapping("/api/v1/image/add")
    Response add(ImageAddReq dto);

    //详情
    @RequestMapping("/api/v1/image/batch_add")
    Response batchAdd(@RequestBody ImageBatchAddReq dto);

    @RequestMapping("/api/v1/image/remove")
    Response remove(Long id);
}













