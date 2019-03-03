package com.wj.demo.dto.req;

import com.wj.demo.base.BasePageDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ImageBatchAddReq extends BasePageDTO implements Serializable {

    @NotNull
    private List<Image> images;

    @Setter
    @Getter
    public static class Image {
        private String name;
        private String url;
    }

}
