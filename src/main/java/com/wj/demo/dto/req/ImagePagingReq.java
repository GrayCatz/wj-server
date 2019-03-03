package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ImagePagingReq extends BasePageDTO implements Serializable {

    private String name;
    private Type type;

    public enum Type {
        PRODUCT,//产品图
        PRODUCT_EXAMPLE,//产品鉴别图标
        PRODUCT_REAL_EXAMPLE//产品鉴别示例图
    }

}
