package com.wj.demo.converter;

import com.wj.demo.base.BaseConverter;
import com.wj.demo.dto.resp.AppraisalDetailResp;
import com.wj.demo.entity.Appraisal;
import com.wj.demo.entity.AppraisalImage;

import java.util.ArrayList;

public class AppraisalDetailConverter extends BaseConverter<Appraisal, AppraisalDetailResp> {

    @Override
    public AppraisalDetailResp toDTO(Appraisal entity) {
        AppraisalDetailResp resp = new AppraisalDetailResp();
        resp.setId(entity.getId());
        resp.setSerial(entity.getSerial());
        resp.setWxSerial(entity.getWxSerial());
        resp.setProductImage(entity.getProduct().getImg());
        resp.setBrand(entity.getProduct().getBrand().getChName());
        resp.setCategory(entity.getProduct().getCategory().getName());
        resp.setProduct(entity.getProduct().getChName());
        resp.setCreator(entity.getCreator());
        resp.setMaster(entity.getMaster().getName());
        resp.setStatus(entity.getStatusText());
        resp.setResult(entity.getResultText());
        resp.setRequired(new ArrayList<>());
        resp.setOptional(new ArrayList<>());


        for (AppraisalImage image : entity.getImages()) {
            AppraisalDetailResp.Image img = new AppraisalDetailResp.Image();
            img.setId(image.getId());
            img.setType(image.getType().name());
            img.setName(image.getName());
            img.setImage(image.getImage());
            switch (image.getType()) {
                case OPTIONAL:
                    resp.getOptional().add(img);
                    break;
                case REQUIRED:
                    resp.getRequired().add(img);
                    break;
            }
        }
        return resp;
    }
}
