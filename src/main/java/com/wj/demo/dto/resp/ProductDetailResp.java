package com.wj.demo.dto.resp;

import com.wj.demo.dto.req.ProductAddReq;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ProductDetailResp implements Serializable {
    private Long id;
    private String name;
    private String category;
    private String brand;
    private String createTime;
    private String creator;
    private String status;
    private String img;
    private boolean delete = false;
    private List<ProductImageType> required;
    private List<ProductImageType> optional;

    @Setter
    @Getter
    public static class ProductImageType {
        private Long id;
        private String type;
        private String name;
        private ProductImage example;
        private ProductImage realExample;
    }

    @Setter
    @Getter
    public static class ProductImage {
        private String url;

        public ProductImage(String url) {
            this.url = url;
        }
    }
}
