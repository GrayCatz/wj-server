package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.ProductDetailResp;
import com.wj.demo.entity.Product;
import com.wj.demo.entity.ProductImage;
import com.wj.demo.utils.DateUtil;

import java.util.ArrayList;

public class ProductDetailConverter extends BaseConverter<Product, ProductDetailResp> {
    @Override
    public ProductDetailResp toDTO(Product product) {
        ProductDetailResp resp = new ProductDetailResp();
        resp.setId(product.getId());
        resp.setName(product.getChName());
        resp.setBrand(product.getBrand().getChName());
        resp.setCategory(product.getCategory().getName());
        resp.setCreateTime(DateUtil.formatNormal(product.getCreateTime()));
        resp.setCreator(product.getCreator());
        resp.setStatus(product.getStatus().name());
        resp.setImg(product.getImg());
        resp.setRequired(new ArrayList<>());
        resp.setOptional(new ArrayList<>());
        for (ProductImage productImage : product.getImages()) {
            ProductDetailResp.ProductImageType pit = new ProductDetailResp.ProductImageType();
            pit.setId(productImage.getId());
            pit.setType(productImage.getType().name());
            pit.setName(productImage.getName());
            pit.setExample(new ProductDetailResp.ProductImage(productImage.getExample()));
            pit.setRealExample(new ProductDetailResp.ProductImage(productImage.getRealExample()));
            switch (productImage.getType()) {
                case OPTIONAL:
                    resp.getOptional().add(pit);
                    break;
                case REQUIRED:
                    resp.getRequired().add(pit);
                    break;
            }
        }
        return resp;
    }
}
