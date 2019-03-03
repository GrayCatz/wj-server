package com.wj.demo.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductPagingResp implements Serializable {
    private Long id;
    private String name;
    private String category;
    private String brand;
    private String createTime;
    private String creator;
    private String status;
}
