package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.ProductPagingResp;
import com.wj.demo.entity.Product;
import com.wj.demo.utils.DateUtil;

public class ProductPagingConverter extends BaseConverter<Product, ProductPagingResp> {
    @Override
    public ProductPagingResp toDTO(Product product) {
        ProductPagingResp resp = new ProductPagingResp();
        resp.setId(product.getId());
        resp.setName(product.getChName());
        resp.setBrand(product.getBrand().getChName());
        resp.setCategory(product.getCategory().getName());
        resp.setCreateTime(DateUtil.formatNormal(product.getCreateTime()));
        resp.setCreator(product.getCreator());
        resp.setStatus(product.getStatus() == Product.Status.ENABLE ? "启用" : "禁用");
        return resp;
    }
}
