package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class ImageAddReq extends BasePageDTO implements Serializable {

    @NotEmpty
    private String name;
    @NotNull
    private Type type;
    @NotEmpty
    private String url;

    public enum Type {
        PRODUCT,//产品图
        PRODUCT_EXAMPLE,//产品鉴别图标
        PRODUCT_REAL_EXAMPLE//产品鉴别示例图
    }

}
