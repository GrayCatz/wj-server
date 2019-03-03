package com.wj.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ProductAddReq implements Serializable {
    private Long id;
    private String name;
    private String img;
    private String category;
    private String brand;
    private String createTime;
    private String creator;
    private Status status;
    private List<ProductImageType> required;
    private List<ProductImageType> optional;
    private List<ProductImageType> remove;

    public enum Status {
        ENABLE, DISABLE
    }

    @Setter
    @Getter
    public static class ProductImageType implements Serializable {
        private Long id;
        private Type type;
        private String name;
        private ProductImage example;
        private ProductImage realExample;
        public enum Type {
            REQUIRED, OPTIONAL
        }
    }

    @Setter
    @Getter
    public static class ProductImage implements Serializable {
        private String url;

        public ProductImage() {
        }

        public ProductImage(String url) {
            this.url = url;
        }
    }
}
