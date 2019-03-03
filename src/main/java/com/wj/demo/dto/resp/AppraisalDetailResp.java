package com.wj.demo.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class AppraisalDetailResp implements Serializable {
    private Long id;
    private String serial;
    private String wxSerial;
    private String brand;
    private String category;
    private String product;
    private String productImage;
    private String creator;
    private String master;
    private String status;
    private String result;

    private List<Image> required;
    private List<Image> optional;

    @Setter
    @Getter
    public static class Image {
        private Long id;
        private String type;
        private String name;
        private String image;
    }

}
