package com.wj.demo.api;

import com.wj.demo.base.Response;
import com.wj.demo.dto.req.AppraisalPagingReq;
import com.wj.demo.dto.req.AppraisalResultUpdateReq;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单服务
 */
//@FeignClient(name = "order-service")
public interface AppraisalService {


    //最新鉴别 订单列表
    @RequestMapping("/api/v1/appraisal/paging")
    Response paging(AppraisalPagingReq dto);

    //最新鉴别 订单列表
    @RequestMapping("/api/v1/appraisal/get")
    Response get(Long id);

    //最新鉴别 订单列表
    @RequestMapping("/api/v1/appraisal_result/update")
    Response get(AppraisalResultUpdateReq req);


//    //提交鉴别单
//    @GetMapping("/api/v1/order/submit_order")
//    Response submit(Request request);
//
//    //提交鉴别单
//    @GetMapping("/api/v1/order/order_detail")
//    Response orderDetail(Request request);
//
//    //我的订单列表
//    @GetMapping("/api/v1/order/my_orders")
//    Response myOrders(Request request);
//
//    //最新鉴别 订单列表
//    @PutMapping("/api/v1/order/latest_orders")
//    Response latestOrders(Request request);


}













