package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.BrandPagingResp;
import com.wj.demo.entity.Brand;
import com.wj.demo.utils.DateUtil;

public class BrandPagingConverter extends BaseConverter<Brand, BrandPagingResp> {

    @Override
    public BrandPagingResp toDTO(Brand brand) {
        BrandPagingResp resp = new BrandPagingResp();
        resp.setId(brand.getId());
        resp.setName(brand.getChName());
        resp.setCreateTime(DateUtil.formatNormal(brand.getCreateTime()));
        resp.setCreator(brand.getCreator());
        resp.setRemark(brand.getRemark());
        return resp;
    }
}
