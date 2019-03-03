package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.CategoryPagingResp;
import com.wj.demo.entity.Category;
import com.wj.demo.utils.DateUtil;

public class CategoryPagingConverter extends BaseConverter<Category, CategoryPagingResp> {

    @Override
    public CategoryPagingResp toDTO(Category category) {
        CategoryPagingResp resp = new CategoryPagingResp();
        resp.setId(category.getId());
        resp.setName(category.getName());
        resp.setCreateTime(DateUtil.formatNormal(category.getCreateTime()));
        resp.setCreator(category.getCreator());
        resp.setRemark(category.getRemark());
        return resp;
    }
}
