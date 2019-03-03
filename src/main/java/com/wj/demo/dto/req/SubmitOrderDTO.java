package com.wj.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class SubmitOrderDTO implements Serializable {

    private Long productId;
    private List<Image> majors;
    private List<Image> minors;
    private Long masterId;
    private String remark;

    @Setter
    @Getter
    public class Image {
        private Long imageTypeId;
        private String name;
        private String suffix;

    }

}
