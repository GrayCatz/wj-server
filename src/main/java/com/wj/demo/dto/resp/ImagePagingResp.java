package com.wj.demo.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ImagePagingResp implements Serializable {

    private Long id;
    private String name;
    private String type;
    private String url;
}
