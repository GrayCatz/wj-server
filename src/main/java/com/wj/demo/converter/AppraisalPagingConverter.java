package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.AppraisalPagingResp;
import com.wj.demo.entity.Appraisal;

public class AppraisalPagingConverter extends BaseConverter<Appraisal, AppraisalPagingResp> {

    @Override
    public AppraisalPagingResp toDTO(Appraisal category) {
        AppraisalPagingResp resp = new AppraisalPagingResp();
        resp.setId(category.getId());
        resp.setSerial(category.getSerial());
        resp.setWxSerial(category.getWxSerial());
        resp.setBrand(category.getProduct().getChName());
        resp.setProduct(category.getProduct().getChName());
        resp.setCreator(category.getCreator());
        resp.setMaster(category.getMaster().getName());
        resp.setStatus(category.getStatusText());
        resp.setResult(category.getResult().name());
        return resp;
    }
}
