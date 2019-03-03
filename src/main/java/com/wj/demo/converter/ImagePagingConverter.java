package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.ImagePagingResp;
import com.wj.demo.entity.Image;

public class ImagePagingConverter extends BaseConverter<Image, ImagePagingResp> {

    @Override
    public ImagePagingResp toDTO(Image image) {
        ImagePagingResp resp = new ImagePagingResp();
        resp.setId(image.getId());
        resp.setName(image.getName());
        resp.setUrl(image.getUrl());
        return resp;
    }
}
